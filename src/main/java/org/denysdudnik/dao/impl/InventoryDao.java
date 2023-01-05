package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Inventory;
import org.hibernate.SessionFactory;

public class InventoryDao extends Dao<Inventory> {

    public InventoryDao(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
