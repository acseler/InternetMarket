package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.server.DAO.HibernateEntity.Category;

import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public interface CategoriesDao {

    List<Category> getCategories();
    List<Category> getCategories(String name);

}
