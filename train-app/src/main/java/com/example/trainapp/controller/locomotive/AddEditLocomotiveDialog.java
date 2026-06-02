package com.example.trainapp.controller.locomotive;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.trainapp.model.Locomotive;
import com.example.trainapp.model.LocomotiveSeries;
import com.example.trainapp.service.LocomotiveSeriesService;
import com.example.trainapp.service.LocomotiveService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AddEditLocomotiveDialog {
    @FXML
    private ComboBox<LocomotiveSeries> seriesCombo;
    @FXML
    private TextField numberField;
    @FXML
    private ComboBox<String> statusCombo;
    @FXML
    private DatePicker repairDatePicker;
    @FXML
    private TextField mileageField;
    @FXML
    private Label errorLabel;
    @FXML
    private Button okButton;

    private Stage dialogStage;
    private Locomotive locomotive;

    @FXML
    private void initialize() {
        statusCombo.getItems().addAll("Рабочий", "Ремонт", "Резерв", "Списан");
        seriesCombo.setItems(FXCollections.observableArrayList(new LocomotiveSeriesService().findAll()));
    }

    private void add() {
        try {
            if (seriesCombo.getValue() == null) throw new IllegalArgumentException("Выберите серию");
            Locomotive newLoc = new Locomotive();
            newLoc.setSeries(seriesCombo.getValue());
            newLoc.setNumber(numberField.getText());
            newLoc.setStatus(statusCombo.getValue());
            LocalDate localDate = repairDatePicker.getValue();
            if (localDate != null) {
                Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                newLoc.setRepairDate(date);
            }
            newLoc.setMileageKm(Integer.parseInt(mileageField.getText()));
            new LocomotiveService().save(newLoc);
            dialogStage.close();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void edit() {
        try {
            locomotive.setSeries(seriesCombo.getValue());
            locomotive.setNumber(numberField.getText());
            locomotive.setStatus(statusCombo.getValue());
            LocalDate localDate = repairDatePicker.getValue();
            if (localDate != null) {
                Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                locomotive.setRepairDate(date);
            } else {
                locomotive.setRepairDate(null);
            }
            locomotive.setMileageKm(Integer.parseInt(mileageField.getText()));
            new LocomotiveService().update(locomotive);
            dialogStage.close();
        } catch (Exception e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialogStage(Stage dialogStage, Locomotive locomotive) {
        this.dialogStage = dialogStage;
        this.locomotive = locomotive;
        seriesCombo.setValue(locomotive.getSeries());
        numberField.setText(locomotive.getNumber());
        statusCombo.setValue(locomotive.getStatus());
        if (locomotive.getRepairDate() != null) {
            repairDatePicker.setValue(locomotive.getRepairDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        }
        mileageField.setText(locomotive.getMileageKm().toString());
        okButton.setOnAction(e -> edit());
    }
}