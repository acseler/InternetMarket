package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.server.DAO.HibernateEntity.Category;
import com.gwt.internetMarket.server.DAO.HibernateEntity.Good;
import com.gwt.internetMarket.server.DAO.HibernateEntity.Manufacture;
import com.gwt.internetMarket.server.DAO.HibernateUtil.HibernateUtility;
import com.gwt.internetMarket.server.DAO.interfaces.GoodDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public class GoodsDaoImpl implements GoodDao {

    public List<Good> getGoods(Manufacture manufacture) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Good.class);
        List<Good> goodList = new ArrayList<Good>(criteria.add(Restrictions.eq("m_id", manufacture)).list());
        session.getTransaction().commit();
        session.close();
        return goodList;
    }

    public List<Good> getGoods(Category category) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Good.class);
        List<Good> goodList = new ArrayList<Good>(criteria.add(Restrictions.eq("c_id", category)).list());
        session.getTransaction().commit();
        session.close();
        return goodList;
    }

    public List<Good> getGoods(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Good.class);
        List<Good> goodList = new ArrayList<Good>(criteria.add(Restrictions.like("g_name", name)).list());
        session.getTransaction().commit();
        session.close();
        return goodList;
    }

    public List<Good> getGoods(int price) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Good.class);
        List<Good> goodList = new ArrayList<Good>(criteria.add(Restrictions.eq("g_price", price)).list());
        session.getTransaction().commit();
        session.close();
        return goodList;
    }

    public List<Good> getGoods(char avail) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Good.class);
        List<Good> goodList = new ArrayList<Good>(criteria.add(Restrictions.eq("g_avail", avail)).list());
        session.getTransaction().commit();
        session.close();
        return goodList;
    }
}
