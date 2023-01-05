package org.denysdudnik;

import org.denysdudnik.factories.impl.MySQLSessionFactory;
import org.denysdudnik.handlers.impl.NewCustomerHandler;
import org.denysdudnik.handlers.impl.NewFilmAvailableEventHandler;
import org.denysdudnik.handlers.impl.RentInventoryEventHandler;
import org.denysdudnik.handlers.impl.ReturnRentedFilmEventHandler;
import org.hibernate.SessionFactory;

public class Main {
    private final SessionFactory sessionFactory;
    private final NewCustomerHandler customerHandler;
    private final ReturnRentedFilmEventHandler returnFilmHandler;
    private final RentInventoryEventHandler rentInventoryHandler;
    private final NewFilmAvailableEventHandler newFilmHandler;

    public Main() {
        sessionFactory = new MySQLSessionFactory().getSessionFactory();
        this.customerHandler = new NewCustomerHandler(sessionFactory);
        this.returnFilmHandler = new ReturnRentedFilmEventHandler(sessionFactory);
        this.rentInventoryHandler = new RentInventoryEventHandler(sessionFactory);
        this.newFilmHandler = new NewFilmAvailableEventHandler(sessionFactory);
    }

    public static void main(String[] args) {
        Main m = new Main();

        m.newFilmHandler.handle(m.sessionFactory);
    }
}
