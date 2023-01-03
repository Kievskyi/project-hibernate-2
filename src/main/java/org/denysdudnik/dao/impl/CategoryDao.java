package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Category;

import java.util.List;
import java.util.Optional;

public class CategoryDao implements Dao<Category> {
    @Override
    public Optional<Category> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
