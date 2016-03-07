package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.shared.CategoryDao;
import com.gwt.internetMarket.server.DAO.HibernateUtil.HibernateUtility;
import com.gwt.internetMarket.server.DAO.interfaces.CategoriesDao;
import com.gwt.internetMarket.shared.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by boduill on 24.02.16.
 * Класс для получения и формирования древа категорий
 */
public class CategoriesDaoImpl implements CategoriesDao {

    public List<Category> getCategories() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CategoryDao.class);
        List<CategoryDao> categoryDaoList = new ArrayList<CategoryDao>(criteria.list());
        session.getTransaction().commit();
        session.close();
        return createTreeHierarchy(categoryDaoList);
    }

    public CategoryDao getCategory(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CategoryDao.class);
        List<CategoryDao> categoryList = new ArrayList<CategoryDao>(criteria.add(Restrictions.eq("name", name)).list());
        session.getTransaction().commit();
        session.close();
        return categoryList.get(0);
    }

    private List<Category> createTreeHierarchy(List<CategoryDao> list) {
        List<Category> result = new ArrayList<Category>();
        for (CategoryDao cat : list) {
            result.add(getCategoryFromDao(cat));
        }
        for (Category parent : result) {
            if (parent.getpId() == 0) {
                for (Category child : result) {
                    if (child.getpId() == parent.getId()) {
                        parent.getSubCategories().add(child.getName());
                    }
                }
            }
        }
        ListIterator<Category> listIterator = result.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().getSubCategories().isEmpty()) {
                listIterator.remove();
            }
        }
        return result;
    }

    private Category getCategoryFromDao (CategoryDao categoryDao) {
        Category result = new Category();
        result.setId(categoryDao.getId());
        result.setName(categoryDao.getName());
        result.setpId(categoryDao.getpId());
        return result;
    }
}
