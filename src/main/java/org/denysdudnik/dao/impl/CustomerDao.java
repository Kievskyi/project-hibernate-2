package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer> {
    @Override
    public Optional<Customer> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
