package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Staff;

import java.util.List;
import java.util.Optional;

public class StaffDao implements Dao<Staff> {
    @Override
    public Optional<Staff> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Staff> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
