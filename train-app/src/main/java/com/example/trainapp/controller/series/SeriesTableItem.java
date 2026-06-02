package com.example.trainapp.controller.series;

import javafx.beans.property.SimpleStringProperty;
import com.example.trainapp.model.LocomotiveSeries;

public class SeriesTableItem {
    private final SimpleStringProperty name;
    private final SimpleStringProperty tractionType;
    private final SimpleStringProperty powerKw;
    private final SimpleStringProperty maxSpeed;
    private final SimpleStringProperty year;
    private final LocomotiveSeries series;

    public SeriesTableItem(LocomotiveSeries series) {
        this.name = new SimpleStringProperty(series.getName());
        this.tractionType = new SimpleStringProperty(series.getTractionType());
        this.powerKw = new SimpleStringProperty(series.getPowerKw().toString());
        this.maxSpeed = new SimpleStringProperty(series.getMaxSpeedKmh().toString());
        this.year = new SimpleStringProperty(series.getYear().toString());
        this.series = series;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getTractionType() {
        return tractionType.get();
    }

    public SimpleStringProperty tractionTypeProperty() {
        return tractionType;
    }

    public void setTractionType(String tt) {
        this.tractionType.set(tt);
    }

    public String getPowerKw() {
        return powerKw.get();
    }

    public SimpleStringProperty powerKwProperty() {
        return powerKw;
    }

    public void setPowerKw(String pk) {
        this.powerKw.set(pk);
    }

    public String getMaxSpeed() {
        return maxSpeed.get();
    }

    public SimpleStringProperty maxSpeedProperty() {
        return maxSpeed;
    }

    public void setMaxSpeed(String ms) {
        this.maxSpeed.set(ms);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String y) {
        this.year.set(y);
    }

    public LocomotiveSeries getSeries() {
        return series;
    }
}