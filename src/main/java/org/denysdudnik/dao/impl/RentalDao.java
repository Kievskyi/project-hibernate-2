package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Customer;
import org.denysdudnik.entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDao extends Dao<Rental> {

    public RentalDao(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getUnreturnedRental(Customer customer, Session session) {
        Query<Rental> query = session.createQuery("from Rental where customerId = :customer_id AND returnDate = null order by RAND()", Rental.class);
        query.setParameter("customer_id", customer);
        query.setMaxResults(1);

        return query.getSingleResult();
    }
}
