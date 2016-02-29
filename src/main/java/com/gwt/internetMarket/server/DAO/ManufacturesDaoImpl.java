package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.shared.ManufactureDao;
import com.gwt.internetMarket.server.DAO.HibernateUtil.HibernateUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public class ManufacturesDaoImpl implements com.gwt.internetMarket.server.DAO.interfaces.ManufactureDao {

    public List<ManufactureDao> getManufacture() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ManufactureDao.class);
        List<ManufactureDao> manufactureDaoList = new ArrayList<ManufactureDao>(criteria.list());
        session.getTransaction().commit();
        session.close();
        return manufactureDaoList;
    }

    public ManufactureDao getManufacture(String name) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ManufactureDao.class);
        List<ManufactureDao> manufactureDaoList = new ArrayList<ManufactureDao>(criteria.
                add(Restrictions.like("name", name)).list());
        session.getTransaction().commit();
        session.close();
        return manufactureDaoList.get(0);
    }
}
