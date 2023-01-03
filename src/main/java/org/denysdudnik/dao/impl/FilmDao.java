package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Film;

import java.util.List;
import java.util.Optional;

public class FilmDao implements Dao<Film> {
    @Override
    public Optional<Film> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Film> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
