package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.server.DAO.HibernateEntity.Category;
import com.gwt.internetMarket.server.DAO.HibernateUtil.HibernateUtility;
import com.gwt.internetMarket.server.DAO.interfaces.CategoriesDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public class CategoriesDaoImpl implements CategoriesDao {

    public List<Category> getCategories() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Category.class);
        List<Category> categoryList = new ArrayList<Category>(criteria.list());
        session.getTransaction().commit();
        session.close();
        return categoryList;
    }

    public List<Category> getCategories(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Category.class);
        List<Category> categoryList = new ArrayList<Category>(criteria.add(Restrictions.like("name", name)).list());
        session.getTransaction().commit();
        session.close();
        return categoryList;
    }
}
