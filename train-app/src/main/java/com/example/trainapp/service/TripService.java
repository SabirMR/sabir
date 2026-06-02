package com.example.trainapp.service;

import com.example.trainapp.model.Trip;
import com.example.trainapp.repository.TripDao;

import java.util.List;

public class TripService {
    private final TripDao dao = new TripDao();

    public List<Trip> findAll() {
        return dao.findAll();
    }

    public Trip findOne(long id) {
        return dao.findOne(id);
    }

    public void save(Trip entity) {
        if (entity != null) dao.save(entity);
    }

    public void update(Trip entity) {
        if (entity != null) dao.update(entity);
    }

    public void delete(Trip entity) {
        if (entity != null) dao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id != null) dao.deleteById(id);
    }
}