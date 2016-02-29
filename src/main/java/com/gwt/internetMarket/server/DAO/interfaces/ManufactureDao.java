package com.gwt.internetMarket.server.DAO.interfaces;

import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public interface ManufactureDao {

    List<com.gwt.internetMarket.shared.ManufactureDao> getManufacture();
    com.gwt.internetMarket.shared.ManufactureDao getManufacture(String name);

}
