package com.example.trainapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Integer tripId;

    @ManyToOne
    @JoinColumn(name = "locomotive_id", nullable = false)
    private Locomotive locomotive;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_time", nullable = false)
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "arrival_time", nullable = false)
    private Date arrivalTime;

    @Column(name = "fuel_consumption", nullable = false)
    private Double fuelConsumption;

    @Column(name = "driver", nullable = false)
    private String driver;

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        if (locomotive == null) throw new IllegalArgumentException("Локомотив не указан");
        this.locomotive = locomotive;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        if (route == null) throw new IllegalArgumentException("Маршрут не указан");
        this.route = route;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        if (departureTime == null) throw new IllegalArgumentException("Время отправления не указано");
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        if (arrivalTime == null) throw new IllegalArgumentException("Время прибытия не указано");
        if (departureTime != null && arrivalTime.before(departureTime))
            throw new IllegalArgumentException("Время прибытия не может быть раньше времени отправления");
        this.arrivalTime = arrivalTime;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        if (fuelConsumption == null || fuelConsumption < 0)
            throw new IllegalArgumentException("Расход топлива должен быть неотрицательным числом");
        this.fuelConsumption = fuelConsumption;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        if (driver == null || driver.trim().isEmpty())
            throw new IllegalArgumentException("Машинист не указан");
        this.driver = driver;
    }
}
