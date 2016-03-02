package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.server.DAO.HibernateUtil.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public class GoodsDaoImpl implements com.gwt.internetMarket.server.DAO.interfaces.GoodDao {

    public List<GoodDao> getGoodsByManufacture(String manufacture) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GoodDao.class);
        List<GoodDao> goodDaoList = new ArrayList<GoodDao>(criteria.add(Restrictions.eq("manufacture", new ManufacturesDaoImpl().getManufacture(manufacture))).list());
        session.getTransaction().commit();
        session.close();
        return goodDaoList;
    }

    public List<GoodDao> getGoodsByCategory(String category) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GoodDao.class);
        List<GoodDao> goodDaoList = new ArrayList<GoodDao>(criteria.add(Restrictions.eq("category", new CategoriesDaoImpl().getCategory(category))).list());
        session.getTransaction().commit();
        session.close();
        return goodDaoList;
    }

    public List<GoodDao> getGoods(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GoodDao.class);
        List<GoodDao> goodDaoList = new ArrayList<GoodDao>(criteria.add(Restrictions.like("name", "%" + name + "%").ignoreCase()).list());
        session.getTransaction().commit();
        session.close();
        return goodDaoList;
    }

}
