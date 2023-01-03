package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Language;

import java.util.List;
import java.util.Optional;

public class LanguageDao implements Dao<Language> {
    @Override
    public Optional<Language> getById(Short id) {
        return Optional.empty();
    }

    @Override
    public List<Language> getAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
