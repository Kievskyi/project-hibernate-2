package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Store;
import org.hibernate.SessionFactory;

public class StoreDao extends Dao<Store> {

    public StoreDao(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
