package com.gwt.internetMarket.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.internetMarket.client.service.IGoodService;
import com.gwt.internetMarket.server.DAO.CategoriesDaoImpl;
import com.gwt.internetMarket.server.DAO.GoodsDaoImpl;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;
import com.gwt.internetMarket.shared.Category;

import java.util.List;

/**
 * Created by boduill on 26.02.16.
 */
public class GoodServiceImpl extends RemoteServiceServlet implements IGoodService {
    public List<ManufactureDao> getManufactures() {
        return null;
    }

    public List<Category> getCategories() {
        return new CategoriesDaoImpl().getCategories();
    }

    public Category getCategoryByName(String name) {
        return null;
    }

    public List<GoodDao> getGoods() {
        return null;
    }

    public List<GoodDao> getGoodsByName(String name) {
        return null;
    }

    public List<GoodDao> getGoodsByCategory(String category) {
        return new GoodsDaoImpl().getGoodsByCategory(category);
    }

    public List<GoodDao> getGoodsByManufacture(String manufacture) {
        return null;
    }

    public List<GoodDao> getGoodByAvail(char avail) {
        return null;
    }
}
