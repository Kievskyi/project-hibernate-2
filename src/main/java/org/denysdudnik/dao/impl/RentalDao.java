package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Rental;

import java.util.List;
import java.util.Optional;

public class RentalDao implements Dao<Rental> {
    @Override
    public Optional<Rental> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Rental> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
