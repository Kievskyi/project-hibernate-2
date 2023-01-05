package org.denysdudnik.handlers.impl;

import org.denysdudnik.dao.impl.*;
import org.denysdudnik.entity.*;
import org.denysdudnik.handlers.Handler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentInventoryEventHandler implements Handler {
    private final RentalDao rentalDao;
    private final CustomerDao customerDao;
    private final InventoryDao inventoryDao;
    private final StoreDao storeDao;
    private final PaymentDao paymentDao;
    private final FilmDao filmDao;

    public RentInventoryEventHandler(SessionFactory sessionFactory) {
        customerDao = new CustomerDao(sessionFactory);
        rentalDao = new RentalDao(sessionFactory);
        inventoryDao = new InventoryDao(sessionFactory);
        storeDao = new StoreDao(sessionFactory);
        paymentDao = new PaymentDao(sessionFactory);
        filmDao = new FilmDao(sessionFactory);
    }

    @Override
    public void handle(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Customer customer = customerDao.getById((short) 601, session);

            Film film = filmDao.getAvailableFilm(session);
            Store store = storeDao.getById((byte) 1, session);

            Inventory inventory = new Inventory();
            inventory.setFilmId(film);
            inventory.setStoreId(store);
            inventoryDao.save(inventory, session);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setCustomer(customer);
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setStaffId(staff);
            rentalDao.save(rental, session);


            Payment payment = new Payment();
            payment.setAmount(BigDecimal.valueOf(0.5));
            payment.setPaymentDate(LocalDateTime.now());
            payment.setCustomerId(customer);
            payment.setRentalId(rental);
            payment.setLastUpdate(LocalDateTime.now());
            payment.setStaffId(staff);

            paymentDao.save(payment, session);

            session.getTransaction().commit();
        }
    }
}
