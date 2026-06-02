package com.example.trainapp.controller.locomotive;

import javafx.beans.property.SimpleStringProperty;
import com.example.trainapp.model.Locomotive;

public class LocomotiveTableItem {
    private final SimpleStringProperty number;
    private final SimpleStringProperty seriesName;
    private final SimpleStringProperty status;
    private final SimpleStringProperty repairDate;
    private final SimpleStringProperty mileage;
    private final Locomotive locomotive;

    public LocomotiveTableItem(Locomotive loc) {
        this.number = new SimpleStringProperty(loc.getNumber());
        this.seriesName = new SimpleStringProperty(loc.getSeries().getName());
        this.status = new SimpleStringProperty(loc.getStatus());
        this.repairDate = new SimpleStringProperty(loc.getRepairDate() == null ? "" : loc.getRepairDate().toString());
        this.mileage = new SimpleStringProperty(loc.getMileageKm().toString());
        this.locomotive = loc;
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String n) {
        number.set(n);
    }

    public String getSeriesName() {
        return seriesName.get();
    }

    public SimpleStringProperty seriesNameProperty() {
        return seriesName;
    }

    public void setSeriesName(String sn) {
        seriesName.set(sn);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String s) {
        status.set(s);
    }

    public String getRepairDate() {
        return repairDate.get();
    }

    public SimpleStringProperty repairDateProperty() {
        return repairDate;
    }

    public void setRepairDate(String rd) {
        repairDate.set(rd);
    }

    public String getMileage() {
        return mileage.get();
    }

    public SimpleStringProperty mileageProperty() {
        return mileage;
    }

    public void setMileage(String m) {
        mileage.set(m);
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }
}