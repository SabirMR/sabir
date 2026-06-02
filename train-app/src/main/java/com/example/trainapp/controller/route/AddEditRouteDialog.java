package com.example.trainapp.controller.route;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.trainapp.model.Route;
import com.example.trainapp.service.RouteService;

public class AddEditRouteDialog {
    @FXML
    private TextField routeNumberField;
    @FXML
    private TextField startStationField;
    @FXML
    private TextField endStationField;
    @FXML
    private TextField dispatcherField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button okButton;

    private Stage dialogStage;
    private Route route;

    private void add() {
        try {
            Route r = new Route();
            r.setRouteNumber(routeNumberField.getText());
            r.setStartStation(startStationField.getText());
            r.setEndStation(endStationField.getText());
            r.setDispatcher(dispatcherField.getText());
            new RouteService().save(r);
            dialogStage.close();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void edit() {
        try {
            route.setRouteNumber(routeNumberField.getText());
            route.setStartStation(startStationField.getText());
            route.setEndStation(endStationField.getText());
            route.setDispatcher(dispatcherField.getText());
            new RouteService().update(route);
            dialogStage.close();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialogStage(Stage dialogStage, Route route) {
        this.dialogStage = dialogStage;
        this.route = route;
        routeNumberField.setText(route.getRouteNumber());
        startStationField.setText(route.getStartStation());
        endStationField.setText(route.getEndStation());
        dispatcherField.setText(route.getDispatcher());
        okButton.setOnAction(e -> edit());
    }
}