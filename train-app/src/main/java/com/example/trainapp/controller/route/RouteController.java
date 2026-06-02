package com.example.trainapp.controller.route;

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
import com.example.trainapp.model.Route;
import com.example.trainapp.service.RouteService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RouteController {
    private ObservableList<RouteTableItem> routeObservable;
    private List<Route> routeList;

    @FXML private TableView<RouteTableItem> routesTable;
    @FXML private TableColumn<RouteTableItem, String> routeNumberColumn;
    @FXML private TableColumn<RouteTableItem, String> startStationColumn;
    @FXML private TableColumn<RouteTableItem, String> endStationColumn;
    @FXML private TableColumn<RouteTableItem, String> dispatcherColumn;

    @FXML private void initialize() {
        routeNumberColumn.setCellValueFactory(new PropertyValueFactory<>("routeNumber"));
        startStationColumn.setCellValueFactory(new PropertyValueFactory<>("startStation"));
        endStationColumn.setCellValueFactory(new PropertyValueFactory<>("endStation"));
        dispatcherColumn.setCellValueFactory(new PropertyValueFactory<>("dispatcher"));
        routeObservable = FXCollections.observableArrayList();
        routesTable.setItems(routeObservable);
        updateList();
    }

    private void updateList() {
        routeList = new RouteService().findAll();
        routeObservable.clear();
        if (routeList != null) {
            for (Route r : routeList) {
                routeObservable.add(new RouteTableItem(r));
            }
        }
        routesTable.refresh();
    }

    @FXML private void btnAddRoute(ActionEvent event) { openDialog(false, null); }
    @FXML private void btnEditRoute(ActionEvent event) {
        RouteTableItem selected = routesTable.getSelectionModel().getSelectedItem();
        if (selected == null) showAlert("Выберите маршрут для редактирования");
        else openDialog(true, selected.getRoute());
    }
    @FXML private void btnDeleteRoute(ActionEvent event) {
        RouteTableItem selected = routesTable.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Выберите маршрут для удаления"); return; }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение удаления");
        alert.setHeaderText("Удаление маршрута");
        alert.setContentText("Удалить маршрут " + selected.getRouteNumber() + "?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            new RouteService().delete(selected.getRoute());
            updateList();
        }
    }
    @FXML private void btnUpdateRoutes(ActionEvent event) { updateList(); }

    private void openDialog(boolean isEdit, Route route) {
        try {
            FXMLLoader loader = new FXMLLoader(TrainApp.class.getResource("/add-edit-route-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(TrainApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            AddEditRouteDialog controller = loader.getController();
            if (isEdit) {
                dialogStage.setTitle("Редактировать маршрут");
                controller.setEditDialogStage(dialogStage, route);
            } else {
                dialogStage.setTitle("Добавить маршрут");
                controller.setAddDialogStage(dialogStage);
            }
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Предупреждение");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML private void btnLocomotives(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.locomotives);
    }
    @FXML private void btnSeries(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.series);
    }
    @FXML private void btnRoutes(ActionEvent event) {
        updateList();
    }
    @FXML private void btnTrips(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.trips);
    }
    @FXML private void btnOff(ActionEvent event) {
        TrainApp.primaryStage.close();
    }
}