package org.denysdudnik.dao.impl;

import org.denysdudnik.dao.Dao;
import org.denysdudnik.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDao extends Dao<Category> {

    public CategoryDao(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
