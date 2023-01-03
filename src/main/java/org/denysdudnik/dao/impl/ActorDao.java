package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Actor;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class ActorDao implements Dao<Actor> {
    @Override
    public Optional<Actor> getById(Short id) {
        Session session = sessionFactory.openSession();

        return Optional.empty();
    }

    @Override
    public List<Actor> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
