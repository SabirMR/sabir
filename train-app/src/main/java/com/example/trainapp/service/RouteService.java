package com.example.trainapp.service;

import com.example.trainapp.model.Route;
import com.example.trainapp.repository.RouteDao;

import java.util.List;

public class RouteService {
    private final RouteDao dao = new RouteDao();

    public List<Route> findAll() {
        return dao.findAll();
    }

    public Route findOne(long id) {
        return dao.findOne(id);
    }

    public void save(Route entity) {
        if (entity != null) dao.save(entity);
    }

    public void update(Route entity) {
        if (entity != null) dao.update(entity);
    }

    public void delete(Route entity) {
        if (entity != null) dao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id != null) dao.deleteById(id);
    }
}