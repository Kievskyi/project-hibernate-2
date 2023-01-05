package org.denysdudnik.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class Dao<T> {
    private final Class<T> clazz;

    public Dao(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
    }

    public T getById(Short id, Session session) {

        return session.get(clazz, id);
    }

    public T getById(Byte id, Session session) {

        return session.get(clazz, id);
    }

    public List<T> getAll(Session session) {
        List<T> list = session.createQuery("from " + clazz.getName(), clazz).list();

        return list;
    }

    public void save(T entity, Session session) {
        session.saveOrUpdate(entity);
    }

    public void update(T entity, Session session) {
        session.merge(entity);
    }


    public void delete(T entity, Session session) {
        session.delete(entity);
    }
}
