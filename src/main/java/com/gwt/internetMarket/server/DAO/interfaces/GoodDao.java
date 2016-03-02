package com.gwt.internetMarket.server.DAO.interfaces;

import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public interface GoodDao {

    List<com.gwt.internetMarket.shared.GoodDao> getGoodsByManufacture(String manufacture);
    List<com.gwt.internetMarket.shared.GoodDao> getGoodsByCategory(String category);
    List<com.gwt.internetMarket.shared.GoodDao> getGoods(String name);

}
