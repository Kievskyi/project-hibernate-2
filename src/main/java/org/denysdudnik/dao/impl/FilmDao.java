package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FilmDao extends Dao<Film> {

    public FilmDao(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getAvailableFilm(Session session) {
        return session.createQuery("select f from Film f where f.id not in (select distinct i.filmId.id from Inventory i)", Film.class)
                .setMaxResults(1)
                .getSingleResult();
    }
}
