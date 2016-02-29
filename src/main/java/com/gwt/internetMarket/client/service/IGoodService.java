package com.gwt.internetMarket.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;
import com.gwt.internetMarket.shared.Category;

import java.util.List;

/**
 * Created by boduill on 25.02.16.
 */
@RemoteServiceRelativePath("goodService")
public interface IGoodService extends RemoteService {
    List<ManufactureDao> getManufactures();
    List<Category> getCategories();
    Category getCategoryByName(String name);
    List<GoodDao> getGoods();
    List<GoodDao> getGoodsByName(String name);
    List<GoodDao> getGoodsByCategory(String category);
    List<GoodDao> getGoodsByManufacture(String manufacture);
    List<GoodDao> getGoodByAvail(char avail);
}
