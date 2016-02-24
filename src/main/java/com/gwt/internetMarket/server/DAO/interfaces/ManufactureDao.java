package com.gwt.internetMarket.server.DAO.interfaces;

import com.gwt.internetMarket.server.DAO.HibernateEntity.Manufacture;

import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public interface ManufactureDao {

    List<Manufacture> getManufacture();
    List<Manufacture> getManufacture(String name);

}
