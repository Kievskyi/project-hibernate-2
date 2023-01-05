package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDao extends Dao<FilmText> {

    public FilmTextDao(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
