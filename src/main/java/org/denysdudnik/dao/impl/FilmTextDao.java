package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.FilmText;

import java.util.List;
import java.util.Optional;

public class FilmTextDao implements Dao<FilmText> {
    @Override
    public Optional<FilmText> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<FilmText> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
