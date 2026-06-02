package com.example.trainapp.service;

import com.example.trainapp.model.Locomotive;
import com.example.trainapp.repository.LocomotiveDao;

import java.util.List;

public class LocomotiveService {
    private final LocomotiveDao dao = new LocomotiveDao();

    public List<Locomotive> findAll() {
        return dao.findAll();
    }

    public Locomotive findOne(long id) {
        return dao.findOne(id);
    }

    public void save(Locomotive entity) {
        if (entity != null) dao.save(entity);
    }

    public void update(Locomotive entity) {
        if (entity != null) dao.update(entity);
    }

    public void delete(Locomotive entity) {
        if (entity != null) dao.delete(entity);
    }

    public void deleteById(Long id) {
        if (id != null) dao.deleteById(id);
    }
}