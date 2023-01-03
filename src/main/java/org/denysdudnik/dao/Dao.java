package org.denysdudnik.dao;

import org.denysdudnik.factories.impl.MySQLSessionFactory;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
     SessionFactory sessionFactory = new MySQLSessionFactory().getSessionFactory();

    Optional<T> getById(Short id);  

    List<T> getAll();

    void update();

    void delete();
}
