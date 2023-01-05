package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Language;
import org.hibernate.SessionFactory;

public class LanguageDao extends Dao<Language> {

    public LanguageDao(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
