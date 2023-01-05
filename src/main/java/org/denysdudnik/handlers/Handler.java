package org.denysdudnik.handlers;

import org.hibernate.SessionFactory;

public interface Handler {

    void handle(SessionFactory sessionFactory);
}
