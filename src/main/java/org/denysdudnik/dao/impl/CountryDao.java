package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Country;

import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country> {
    @Override
    public Optional<Country> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
