package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Address;
import org.hibernate.SessionFactory;

public class AddressDao extends Dao<Address> {

    public AddressDao(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
