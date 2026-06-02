package com.example.trainapp.controller.route;

import javafx.beans.property.SimpleStringProperty;
import com.example.trainapp.model.Route;

public class RouteTableItem {
    private final SimpleStringProperty routeNumber;
    private final SimpleStringProperty startStation;
    private final SimpleStringProperty endStation;
    private final SimpleStringProperty dispatcher;
    private final Route route;

    public RouteTableItem(Route route) {
        this.routeNumber = new SimpleStringProperty(route.getRouteNumber());
        this.startStation = new SimpleStringProperty(route.getStartStation());
        this.endStation = new SimpleStringProperty(route.getEndStation());
        this.dispatcher = new SimpleStringProperty(route.getDispatcher());
        this.route = route;
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

    public String getStartStation() {
        return startStation.get();
    }

    public SimpleStringProperty startStationProperty() {
        return startStation;
    }

    public void setStartStation(String ss) {
        this.startStation.set(ss);
    }

    public String getEndStation() {
        return endStation.get();
    }

    public SimpleStringProperty endStationProperty() {
        return endStation;
    }

    public void setEndStation(String es) {
        this.endStation.set(es);
    }

    public String getDispatcher() {
        return dispatcher.get();
    }

    public SimpleStringProperty dispatcherProperty() {
        return dispatcher;
    }

    public void setDispatcher(String d) {
        this.dispatcher.set(d);
    }

    public Route getRoute() {
        return route;
    }
}