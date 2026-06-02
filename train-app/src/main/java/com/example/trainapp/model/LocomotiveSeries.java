package com.example.trainapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "locomotive_series")
public class LocomotiveSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Integer seriesId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "traction_type", nullable = false)
    private String tractionType;

    @Column(name = "power_kw", nullable = false)
    private Integer powerKw;

    @Column(name = "max_speed_kmh", nullable = false)
    private Integer maxSpeedKmh;

    @Column(name = "year", nullable = false)
    private Integer year;

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Наименование серии не может быть пустым");
        this.name = name;
    }

    public String getTractionType() {
        return tractionType;
    }

    public void setTractionType(String tractionType) {
        if (tractionType == null || tractionType.trim().isEmpty())
            throw new IllegalArgumentException("Тип тяги не может быть пустым");
        this.tractionType = tractionType;
    }

    public Integer getPowerKw() {
        return powerKw;
    }

    public void setPowerKw(Integer powerKw) {
        if (powerKw == null || powerKw <= 0)
            throw new IllegalArgumentException("Мощность должна быть положительным числом");
        this.powerKw = powerKw;
    }

    public Integer getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public void setMaxSpeedKmh(Integer maxSpeedKmh) {
        if (maxSpeedKmh == null || maxSpeedKmh <= 0)
            throw new IllegalArgumentException("Максимальная скорость должна быть положительной");
        this.maxSpeedKmh = maxSpeedKmh;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year == null || year < 1800 || year > 2100)
            throw new IllegalArgumentException("Некорректный год выпуска серии");
        this.year = year;
    }

    @Override
    public String toString() {
        return name;
    }
}