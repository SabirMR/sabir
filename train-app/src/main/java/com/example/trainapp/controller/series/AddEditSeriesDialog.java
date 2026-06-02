package com.example.trainapp.controller.series;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.trainapp.model.LocomotiveSeries;
import com.example.trainapp.service.LocomotiveSeriesService;

public class AddEditSeriesDialog {
    @FXML private TextField nameField;
    @FXML private TextField tractionTypeField;
    @FXML private TextField powerKwField;
    @FXML private TextField maxSpeedField;
    @FXML private TextField yearField;
    @FXML private Label errorLabel;
    @FXML private Button okButton;

    private Stage dialogStage;
    private LocomotiveSeries series;

    private void add() {
        try {
            LocomotiveSeries newSeries = new LocomotiveSeries();
            newSeries.setName(nameField.getText());
            newSeries.setTractionType(tractionTypeField.getText());
            newSeries.setPowerKw(Integer.parseInt(powerKwField.getText()));
            newSeries.setMaxSpeedKmh(Integer.parseInt(maxSpeedField.getText()));
            newSeries.setYear(Integer.parseInt(yearField.getText()));
            new LocomotiveSeriesService().save(newSeries);
            dialogStage.close();
        } catch (NumberFormatException e) {
            errorLabel.setText("Проверьте числовые поля");
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    private void edit() {
        try {
            series.setName(nameField.getText());
            series.setTractionType(tractionTypeField.getText());
            series.setPowerKw(Integer.parseInt(powerKwField.getText()));
            series.setMaxSpeedKmh(Integer.parseInt(maxSpeedField.getText()));
            series.setYear(Integer.parseInt(yearField.getText()));
            new LocomotiveSeriesService().update(series);
            dialogStage.close();
        } catch (NumberFormatException e) {
            errorLabel.setText("Проверьте числовые поля");
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialogStage(Stage dialogStage, LocomotiveSeries series) {
        this.dialogStage = dialogStage;
        this.series = series;
        nameField.setText(series.getName());
        tractionTypeField.setText(series.getTractionType());
        powerKwField.setText(series.getPowerKw().toString());
        maxSpeedField.setText(series.getMaxSpeedKmh().toString());
        yearField.setText(series.getYear().toString());
        okButton.setOnAction(e -> edit());
    }
}