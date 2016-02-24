package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.server.DAO.HibernateEntity.Manufacture;
import com.gwt.internetMarket.server.DAO.HibernateUtil.HibernateUtility;
import com.gwt.internetMarket.server.DAO.interfaces.ManufactureDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public class ManufacturesDaoImpl implements ManufactureDao {

    public List<Manufacture> getManufacture() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Manufacture.class);
        List<Manufacture> manufactureList = new ArrayList<Manufacture>(criteria.list());
        session.getTransaction().commit();
        session.close();
        return manufactureList;
    }

    public List<Manufacture> getManufacture(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Manufacture.class);
        List<Manufacture> manufactureList = new ArrayList<Manufacture>(criteria.
                add(Restrictions.like("name", name)).list());
        session.getTransaction().commit();
        session.close();
        return manufactureList;
    }
}
