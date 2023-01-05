package org.denysdudnik.factories;

import org.hibernate.SessionFactory;

public interface MySessionFactory {

    SessionFactory getSessionFactory();
}
