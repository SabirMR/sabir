package com.example.trainapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "route_number", nullable = false, unique = true)
    private String routeNumber;

    @Column(name = "start_station", nullable = false)
    private String startStation;

    @Column(name = "end_station", nullable = false)
    private String endStation;

    @Column(name = "dispatcher", nullable = false)
    private String dispatcher;

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        if (routeNumber == null || routeNumber.trim().isEmpty())
            throw new IllegalArgumentException("Номер маршрута не может быть пустым");
        this.routeNumber = routeNumber;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        if (startStation == null || startStation.trim().isEmpty())
            throw new IllegalArgumentException("Начальная станция не может быть пустой");
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        if (endStation == null || endStation.trim().isEmpty())
            throw new IllegalArgumentException("Конечная станция не может быть пустой");
        this.endStation = endStation;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        if (dispatcher == null || dispatcher.trim().isEmpty())
            throw new IllegalArgumentException("Диспетчер не может быть пустым");
        this.dispatcher = dispatcher;
    }

    @Override
    public String toString() {
        return routeNumber + " (" + startStation + " - " + endStation + ")";
    }
}