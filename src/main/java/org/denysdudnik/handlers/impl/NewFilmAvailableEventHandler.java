package org.denysdudnik.handlers.impl;

import org.denysdudnik.dao.impl.*;
import org.denysdudnik.entity.*;
import org.denysdudnik.enums.Feature;
import org.denysdudnik.enums.Rating;
import org.denysdudnik.handlers.Handler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.Set;

public class NewFilmAvailableEventHandler implements Handler {
    private final FilmTextDao filmTextDao;
    private final CategoryDao categoryDao;
    private final ActorDao actorDao;
    private final LanguageDao languageDao;
    private final FilmDao filmDao;

    public NewFilmAvailableEventHandler(SessionFactory sessionFactory) {
        filmTextDao = new FilmTextDao(sessionFactory);
        categoryDao = new CategoryDao(sessionFactory);
        actorDao = new ActorDao(sessionFactory);
        languageDao = new LanguageDao(sessionFactory);
        filmDao = new FilmDao(sessionFactory);
    }

    @Override
    public void handle(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Category category1 = categoryDao.getById((byte) 1, session);
            Category category2 = categoryDao.getById((byte) 2, session);
            Set<Category> categories = Set.of(category1, category2);

            Actor actor1 = actorDao.getById((short) 1, session);
            Actor actor2 = actorDao.getById((short) 2, session);
            Actor actor3 = actorDao.getById((short) 3, session);
            Set<Actor> actors = Set.of(actor1, actor2, actor3);

            Language language = languageDao.getById((byte) 3, session);

            Film film = new Film();
            film.setTitle("Самий крутой фільм!");
            film.setDescription("Какой крутой фильм!");
            film.setCategories(categories);
            film.setActors(actors);
            film.setYear(2023);
            film.setLanguage(language);
            film.setRentalDuration((byte) 5);
            film.setRentalRate(BigDecimal.valueOf(4.99));
            film.setLength((short) 120);
            film.setReplacementCost(BigDecimal.valueOf(25.99));
            film.setRating(Rating.NC17);
            film.setSpecialFeatures(Set.of(Feature.COMMENTARIES, Feature.TRAILERS));

            filmDao.save(film, session);

            FilmText filmText = new FilmText();
            filmText.setId(film.getId());
            filmText.setFilm(film);
            filmText.setDescription("Какой крутой фильм!");
            filmText.setTitle("Самий крутой фільм!");

            filmTextDao.save(filmText, session);

            session.getTransaction().commit();
        }
    }
}
