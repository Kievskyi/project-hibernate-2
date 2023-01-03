package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Address;

import java.util.List;
import java.util.Optional;

public class AddressDao implements Dao<Address> {
    @Override
    public Optional<Address> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
