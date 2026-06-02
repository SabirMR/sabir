package com.example.trainapp.controller.trip;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.trainapp.model.Locomotive;
import com.example.trainapp.model.Route;
import com.example.trainapp.model.Trip;
import com.example.trainapp.service.LocomotiveService;
import com.example.trainapp.service.RouteService;
import com.example.trainapp.service.TripService;

import java.time.ZoneId;
import java.util.Date;

public class AddEditTripDialog {
    @FXML
    private ComboBox<Locomotive> locomotiveCombo;
    @FXML
    private ComboBox<Route> routeCombo;
    @FXML
    private DatePicker departureDatePicker;
    @FXML
    private DatePicker arrivalDatePicker;
    @FXML
    private TextField fuelField;
    @FXML
    private TextField driverField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button okButton;

    private Stage dialogStage;
    private Trip trip;

    @FXML
    private void initialize() {
        locomotiveCombo.setItems(FXCollections.observableArrayList(new LocomotiveService().findAll()));
        routeCombo.setItems(FXCollections.observableArrayList(new RouteService().findAll()));
    }

    private void add() {
        try {
            if (locomotiveCombo.getValue() == null || routeCombo.getValue() == null)
                throw new IllegalArgumentException("Заполните все поля");
            Trip t = new Trip();
            t.setLocomotive(locomotiveCombo.getValue());
            t.setRoute(routeCombo.getValue());
            t.setDepartureTime(Date.from(departureDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            t.setArrivalTime(Date.from(arrivalDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            t.setFuelConsumption(Double.parseDouble(fuelField.getText()));
            t.setDriver(driverField.getText());
            new TripService().save(t);
            dialogStage.close();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void edit() {
        try {
            trip.setLocomotive(locomotiveCombo.getValue());
            trip.setRoute(routeCombo.getValue());
            trip.setDepartureTime(Date.from(departureDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            trip.setArrivalTime(Date.from(arrivalDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            trip.setFuelConsumption(Double.parseDouble(fuelField.getText()));
            trip.setDriver(driverField.getText());
            new TripService().update(trip);
            dialogStage.close();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialogStage(Stage dialogStage, Trip trip) {
        this.dialogStage = dialogStage;
        this.trip = trip;
        locomotiveCombo.setValue(trip.getLocomotive());
        routeCombo.setValue(trip.getRoute());
        departureDatePicker.setValue(trip.getDepartureTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        arrivalDatePicker.setValue(trip.getArrivalTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        fuelField.setText(trip.getFuelConsumption().toString());
        driverField.setText(trip.getDriver());
        okButton.setOnAction(e -> edit());
    }
}