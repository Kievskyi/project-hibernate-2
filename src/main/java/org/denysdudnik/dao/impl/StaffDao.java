package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Staff;
import org.denysdudnik.entity.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StaffDao extends Dao<Staff> {


    public StaffDao(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }

}
