package org.denysdudnik.handlers.impl;

import org.denysdudnik.dao.impl.CustomerDao;
import org.denysdudnik.dao.impl.RentalDao;
import org.denysdudnik.entity.Customer;
import org.denysdudnik.entity.Rental;
import org.denysdudnik.handlers.Handler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;

public class ReturnRentedFilmEventHandler implements Handler {
    private final RentalDao rentalDao;
    private final CustomerDao customerDao;


    public ReturnRentedFilmEventHandler(SessionFactory sessionFactory) {
        rentalDao = new RentalDao(sessionFactory);
        customerDao = new CustomerDao(sessionFactory);
    }

    @Override
    public void handle(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Customer customer = customerDao.getById((short) 111, session);
            Rental unreturnedRental = rentalDao.getUnreturnedRental(customer, session);
            unreturnedRental.setReturnDate(LocalDateTime.now());

            rentalDao.update(unreturnedRental, session);

            session.getTransaction().commit();
        }
    }
}
