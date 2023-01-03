package org.denysdudnik.factories.impl;

import org.denysdudnik.entity.*;
import org.denysdudnik.factories.MySessionFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class MySQLSessionFactory implements MySessionFactory {
    private final SessionFactory sessionFactory;

    public MySQLSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "validate");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");

        sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
