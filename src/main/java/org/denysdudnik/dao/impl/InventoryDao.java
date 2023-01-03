package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Inventory;

import java.util.List;
import java.util.Optional;

public class InventoryDao implements Dao<Inventory> {
    @Override
    public Optional<Inventory> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Inventory> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
