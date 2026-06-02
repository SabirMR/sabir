package com.example.trainapp.controller.trip;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.example.trainapp.TrainApp;
import com.example.trainapp.model.Trip;
import com.example.trainapp.service.TripService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TripController {
    private ObservableList<TripTableItem> tripObservable;
    private List<Trip> tripList;

    @FXML
    private TableView<TripTableItem> tripsTable;
    @FXML
    private TableColumn<TripTableItem, String> locomotiveColumn;
    @FXML
    private TableColumn<TripTableItem, String> routeColumn;
    @FXML
    private TableColumn<TripTableItem, String> departureColumn;
    @FXML
    private TableColumn<TripTableItem, String> arrivalColumn;
    @FXML
    private TableColumn<TripTableItem, String> fuelColumn;
    @FXML
    private TableColumn<TripTableItem, String> driverColumn;

    @FXML
    private void initialize() {
        locomotiveColumn.setCellValueFactory(new PropertyValueFactory<>("locomotiveNumber"));
        routeColumn.setCellValueFactory(new PropertyValueFactory<>("routeNumber"));
        departureColumn.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        arrivalColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        fuelColumn.setCellValueFactory(new PropertyValueFactory<>("fuelConsumption"));
        driverColumn.setCellValueFactory(new PropertyValueFactory<>("driver"));
        tripObservable = FXCollections.observableArrayList();
        tripsTable.setItems(tripObservable);
        updateList();
    }

    private void updateList() {
        tripList = new TripService().findAll();
        tripObservable.clear();
        if (tripList != null) {
            for (Trip t : tripList) {
                tripObservable.add(new TripTableItem(t));
            }
        }
        tripsTable.refresh();
    }

    @FXML
    private void btnAddTrip(ActionEvent event) {
        openDialog(false, null);
    }

    @FXML
    private void btnEditTrip(ActionEvent event) {
        TripTableItem selected = tripsTable.getSelectionModel().getSelectedItem();
        if (selected == null) showAlert("Выберите рейс для редактирования");
        else openDialog(true, selected.getTrip());
    }

    @FXML
    private void btnDeleteTrip(ActionEvent event) {
        TripTableItem selected = tripsTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Выберите рейс для удаления");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение удаления");
        alert.setHeaderText("Удаление рейса");
        alert.setContentText("Удалить рейс " + selected.getLocomotiveNumber() + " - " + selected.getRouteNumber() + "?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            new TripService().delete(selected.getTrip());
            updateList();
        }
    }

    @FXML
    private void btnUpdateTrips(ActionEvent event) {
        updateList();
    }

    private void openDialog(boolean isEdit, Trip trip) {
        try {
            FXMLLoader loader = new FXMLLoader(TrainApp.class.getResource("/add-edit-trip-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(TrainApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            AddEditTripDialog controller = loader.getController();
            if (isEdit) {
                dialogStage.setTitle("Редактировать рейс");
                controller.setEditDialogStage(dialogStage, trip);
            } else {
                dialogStage.setTitle("Добавить рейс");
                controller.setAddDialogStage(dialogStage);
            }
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Предупреждение");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    private void btnLocomotives(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.locomotives);
    }

    @FXML
    private void btnSeries(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.series);
    }

    @FXML
    private void btnRoutes(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.routes);
    }

    @FXML
    private void btnTrips(ActionEvent event) {
        updateList();
    }

    @FXML
    private void btnOff(ActionEvent event) {
        TrainApp.primaryStage.close();
    }
}