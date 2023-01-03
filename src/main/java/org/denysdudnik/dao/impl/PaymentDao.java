package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Payment;

import java.util.List;
import java.util.Optional;

public class PaymentDao implements Dao<Payment> {
    @Override
    public Optional<Payment> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Payment> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
