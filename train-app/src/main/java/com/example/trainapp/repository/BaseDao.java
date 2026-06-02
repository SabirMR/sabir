package com.example.trainapp.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.trainapp.util.HibernateSessionFactoryUtil;

import java.util.List;

public abstract class BaseDao<T> {
    private final Class<T> clazz;

    public BaseDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    protected Session getCurrentSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().getCurrentSession();
    }

    public void save(T entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(entity);
        tx.commit();
        session.close();
    }

    public void update(T entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
        session.close();
    }

    public void delete(T entity) {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
        session.close();
    }

    public void deleteById(long id) {
        T entity = findOne(id);
        if (entity != null) delete(entity);
    }

    public T findOne(long id) {
        Session session = getCurrentSession();
        session.beginTransaction();
        T entity = session.get(clazz, id);
        session.close();
        return entity;
    }

    public List<T> findAll() {
        Session session = getCurrentSession();
        session.beginTransaction();
        List<T> list = session.createQuery("from " + clazz.getName(), clazz).list();
        session.close();
        return list;
    }
}
