package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.City;

import java.util.List;
import java.util.Optional;

public class CityDao implements Dao<City> {
    @Override
    public Optional<City> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
