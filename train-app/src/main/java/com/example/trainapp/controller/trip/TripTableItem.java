package com.example.trainapp.controller.trip;

import javafx.beans.property.SimpleStringProperty;
import com.example.trainapp.model.Trip;

public class TripTableItem {
    private final SimpleStringProperty locomotiveNumber;
    private final SimpleStringProperty routeNumber;
    private final SimpleStringProperty departureTime;
    private final SimpleStringProperty arrivalTime;
    private final SimpleStringProperty fuelConsumption;
    private final SimpleStringProperty driver;
    private final Trip trip;

    public TripTableItem(Trip trip) {
        this.locomotiveNumber = new SimpleStringProperty(trip.getLocomotive().getNumber());
        this.routeNumber = new SimpleStringProperty(trip.getRoute().getRouteNumber());
        this.departureTime = new SimpleStringProperty(trip.getDepartureTime().toString());
        this.arrivalTime = new SimpleStringProperty(trip.getArrivalTime().toString());
        this.fuelConsumption = new SimpleStringProperty(trip.getFuelConsumption().toString());
        this.driver = new SimpleStringProperty(trip.getDriver());
        this.trip = trip;
    }

    public String getLocomotiveNumber() {
        return locomotiveNumber.get();
    }

    public SimpleStringProperty locomotiveNumberProperty() {
        return locomotiveNumber;
    }

    public void setLocomotiveNumber(String ln) {
        this.locomotiveNumber.set(ln);
    }

    public String getRouteNumber() {
        return routeNumber.get();
    }

    public SimpleStringProperty routeNumberProperty() {
        return routeNumber;
    }

    public void setRouteNumber(String rn) {
        this.routeNumber.set(rn);
    }

    public String getDepartureTime() {
        return departureTime.get();
    }

    public SimpleStringProperty departureTimeProperty() {
        return departureTime;
    }

    public void setDepartureTime(String dt) {
        this.departureTime.set(dt);
    }

    public String getArrivalTime() {
        return arrivalTime.get();
    }

    public SimpleStringProperty arrivalTimeProperty() {
        return arrivalTime;
    }

    public void setArrivalTime(String at) {
        this.arrivalTime.set(at);
    }

    public String getFuelConsumption() {
        return fuelConsumption.get();
    }

    public SimpleStringProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fc) {
        this.fuelConsumption.set(fc);
    }

    public String getDriver() {
        return driver.get();
    }

    public SimpleStringProperty driverProperty() {
        return driver;
    }

    public void setDriver(String d) {
        this.driver.set(d);
    }

    public Trip getTrip() {
        return trip;
    }
}