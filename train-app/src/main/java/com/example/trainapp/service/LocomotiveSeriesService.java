package com.example.trainapp.service;

import com.example.trainapp.model.LocomotiveSeries;
import com.example.trainapp.repository.LocomotiveSeriesDao;

import java.util.List;

public class LocomotiveSeriesService {
    private final LocomotiveSeriesDao dao = new LocomotiveSeriesDao();

    public List<LocomotiveSeries> findAll() {
        return dao.findAll();
    }

    public LocomotiveSeries findOne(long id) {
        return dao.findOne(id);
    }

    public void save(LocomotiveSeries entity) {
        if (entity != null) dao.save(entity);
    }

    public void update(LocomotiveSeries entity) {
        if (entity != null) dao.update(entity);
    }

    public void delete(LocomotiveSeries entity) {
        if (entity != null) dao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id != null) dao.deleteById(id);
    }
}