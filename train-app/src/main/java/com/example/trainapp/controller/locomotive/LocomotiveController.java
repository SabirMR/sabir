package com.example.trainapp.controller.locomotive;

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
import com.example.trainapp.model.Locomotive;
import com.example.trainapp.service.LocomotiveService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LocomotiveController {
    private ObservableList<LocomotiveTableItem> locomotivesObservable;
    private List<Locomotive> locomotives;

    @FXML
    private TableView<LocomotiveTableItem> locomotivesTable;
    @FXML
    private TableColumn<LocomotiveTableItem, String> numberColumn;
    @FXML
    private TableColumn<LocomotiveTableItem, String> seriesColumn;
    @FXML
    private TableColumn<LocomotiveTableItem, String> statusColumn;
    @FXML
    private TableColumn<LocomotiveTableItem, String> repairDateColumn;
    @FXML
    private TableColumn<LocomotiveTableItem, String> mileageColumn;

    @FXML
    private void initialize() {
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        seriesColumn.setCellValueFactory(new PropertyValueFactory<>("seriesName"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        repairDateColumn.setCellValueFactory(new PropertyValueFactory<>("repairDate"));
        mileageColumn.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        locomotivesObservable = FXCollections.observableArrayList();
        locomotivesTable.setItems(locomotivesObservable);
        updateList();
    }

    private void updateList() {
        locomotives = new LocomotiveService().findAll();
        locomotivesObservable.clear();
        if (locomotives != null) {
            for (Locomotive loc : locomotives) {
                locomotivesObservable.add(new LocomotiveTableItem(loc));
            }
        }
        locomotivesTable.refresh();
    }

    @FXML
    private void btnAddLocomotive(ActionEvent event) {
        openDialog(false, null);
    }

    @FXML
    private void btnEditLocomotive(ActionEvent event) {
        LocomotiveTableItem selected = locomotivesTable.getSelectionModel().getSelectedItem();
        if (selected == null) showAlert("Выберите локомотив для редактирования");
        else openDialog(true, selected.getLocomotive());
    }

    @FXML
    private void btnDeleteLocomotive(ActionEvent event) {
        LocomotiveTableItem selected = locomotivesTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Выберите локомотив для удаления");
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение удаления");
        alert.setHeaderText("Удаление локомотива");
        alert.setContentText("Удалить локомотив " + selected.getNumber() + "?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            new LocomotiveService().delete(selected.getLocomotive());
            updateList();
        }
    }

    @FXML
    private void btnUpdateLocomotives(ActionEvent event) {
        updateList();
    }

    private void openDialog(boolean isEdit, Locomotive locomotive) {
        try {
            FXMLLoader loader = new FXMLLoader(TrainApp.class.getResource("/add-edit-locomotive-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(TrainApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            AddEditLocomotiveDialog controller = loader.getController();
            if (isEdit) {
                dialogStage.setTitle("Редактировать локомотив");
                controller.setEditDialogStage(dialogStage, locomotive);
            } else {
                dialogStage.setTitle("Добавить локомотив");
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
        updateList();
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
        TrainApp.primaryStage.setScene(TrainApp.trips);
    }

    @FXML
    private void btnOff(ActionEvent event) {
        TrainApp.primaryStage.close();
    }
}