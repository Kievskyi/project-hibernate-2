package org.denysdudnik.handlers.impl;

import org.denysdudnik.dao.impl.AddressDao;
import org.denysdudnik.dao.impl.CityDao;
import org.denysdudnik.dao.impl.CustomerDao;
import org.denysdudnik.dao.impl.StoreDao;
import org.denysdudnik.entity.Address;
import org.denysdudnik.entity.Customer;
import org.denysdudnik.handlers.Handler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;

public class NewCustomerHandler implements Handler {
    private final StoreDao storeDao;
    private final CityDao cityDao;
    private final CustomerDao customerDao;
    private final AddressDao addressDao;


    public NewCustomerHandler(SessionFactory sessionFactory) {
        storeDao = new StoreDao(sessionFactory);
        cityDao = new CityDao(sessionFactory);
        customerDao = new CustomerDao(sessionFactory);
        addressDao = new AddressDao(sessionFactory);
    }

    @Override
    public void handle(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Address address = new Address().builder()
                    .address("ddddd")
                    .address2("sddddd")
                    .city(cityDao.getById((short) 1, session))
                    .district("ddddd")
                    .phone("2413251356")
                    .postalCode("135")
                    .build();

            addressDao.save(address, session);

            Customer customer = new Customer().builder()
                    .email("sgf@gmail.com")
                    .active(true)
                    .createDate(LocalDateTime.now())
                    .firstName("Denys")
                    .lastName("Denyska")
                    .storeId(storeDao.getById((byte) 1, session))
                    .address(address)
                    .build();

            customerDao.save(customer, session);

            session.getTransaction().commit();
        }
    }
}
