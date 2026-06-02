package com.example.trainapp.controller.series;

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
import com.example.trainapp.model.LocomotiveSeries;
import com.example.trainapp.service.LocomotiveSeriesService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class SeriesController {
    private ObservableList<SeriesTableItem> seriesObservable;
    private List<LocomotiveSeries> seriesList;

    @FXML
    private TableView<SeriesTableItem> seriesTable;
    @FXML
    private TableColumn<SeriesTableItem, String> nameColumn;
    @FXML
    private TableColumn<SeriesTableItem, String> tractionTypeColumn;
    @FXML
    private TableColumn<SeriesTableItem, String> powerKwColumn;
    @FXML
    private TableColumn<SeriesTableItem, String> maxSpeedColumn;
    @FXML
    private TableColumn<SeriesTableItem, String> yearColumn;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tractionTypeColumn.setCellValueFactory(new PropertyValueFactory<>("tractionType"));
        powerKwColumn.setCellValueFactory(new PropertyValueFactory<>("powerKw"));
        maxSpeedColumn.setCellValueFactory(new PropertyValueFactory<>("maxSpeed"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        seriesObservable = FXCollections.observableArrayList();
        seriesTable.setItems(seriesObservable);
        updateList();
    }

    private void updateList() {
        seriesList = new LocomotiveSeriesService().findAll();
        seriesObservable.clear();
        if (seriesList != null) {
            for (LocomotiveSeries s : seriesList) {
                seriesObservable.add(new SeriesTableItem(s));
            }
        }
        seriesTable.refresh();
    }

    @FXML
    private void btnAddSeries(ActionEvent event) {
        openDialog(false, null);
    }

    @FXML
    private void btnEditSeries(ActionEvent event) {
        SeriesTableItem selected = seriesTable.getSelectionModel().getSelectedItem();
        if (selected == null) showAlert("Выберите серию для редактирования");
        else openDialog(true, selected.getSeries());
    }

    @FXML
    private void btnDeleteSeries(ActionEvent event) {
        SeriesTableItem selected = seriesTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Выберите серию для удаления");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение удаления");
        alert.setHeaderText("Удаление серии");
        alert.setContentText("Удалить серию " + selected.getName() + "?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            new LocomotiveSeriesService().delete(selected.getSeries());
            updateList();
        }
    }

    @FXML
    private void btnUpdateSeries(ActionEvent event) {
        updateList();
    }

    private void openDialog(boolean isEdit, LocomotiveSeries series) {
        try {
            FXMLLoader loader = new FXMLLoader(TrainApp.class.getResource("/add-edit-series-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(TrainApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            AddEditSeriesDialog controller = loader.getController();
            if (isEdit) {
                dialogStage.setTitle("Редактировать серию");
                controller.setEditDialogStage(dialogStage, series);
            } else {
                dialogStage.setTitle("Добавить серию");
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
        updateList();
    }

    @FXML
    private void btnRoutes(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.routes);
    }

    @FXML
    private void btnTrips(ActionEvent event) {
        TrainApp.primaryStage.setScene(TrainApp.trips);
    }

    @FXML
    private void btnOff(ActionEvent event) {
        TrainApp.primaryStage.close();
    }
}