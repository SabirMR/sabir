package com.example.trainapp.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "locomotives")
public class Locomotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotive_id")
    private Integer locomotiveId;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = false)
    private LocomotiveSeries series;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Column(name = "status", nullable = false)
    private String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "repair_date")
    private Date repairDate;

    @Column(name = "mileage_km", nullable = false)
    private Integer mileageKm;

    public Integer getLocomotiveId() {
        return locomotiveId;
    }

    public void setLocomotiveId(Integer locomotiveId) {
        this.locomotiveId = locomotiveId;
    }

    public LocomotiveSeries getSeries() {
        return series;
    }

    public void setSeries(LocomotiveSeries series) {
        if (series == null) throw new IllegalArgumentException("Серия локомотива не указана");
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null || number.trim().isEmpty())
            throw new IllegalArgumentException("Номер машины не может быть пустым");
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty())
            throw new IllegalArgumentException("Статус не может быть пустым");
        this.status = status;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Integer getMileageKm() {
        return mileageKm;
    }

    public void setMileageKm(Integer mileageKm) {
        if (mileageKm == null || mileageKm < 0)
            throw new IllegalArgumentException("Пробег не может быть отрицательным");
        this.mileageKm = mileageKm;
    }

    @Override
    public String toString() {
        return number + " (" + series.getName() + ")";
    }
}