package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Store;

import java.util.List;
import java.util.Optional;

public class StoreDao implements Dao<Store> {
    @Override
    public Optional<Store> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Store> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}