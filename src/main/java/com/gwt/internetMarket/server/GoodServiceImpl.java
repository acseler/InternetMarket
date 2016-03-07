package com.gwt.internetMarket.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.internetMarket.client.service.IGoodService;
import com.gwt.internetMarket.server.DAO.CategoriesDaoImpl;
import com.gwt.internetMarket.server.DAO.GoodsDaoImpl;
import com.gwt.internetMarket.server.DAO.ManufacturesDaoImpl;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;
import com.gwt.internetMarket.shared.Category;

import java.util.List;

/**
 * Created by boduill on 26.02.16.
 * Сервис для получения древа категорий, списка производителей и товаров.
 */
public class GoodServiceImpl extends RemoteServiceServlet implements IGoodService {
    public List<ManufactureDao> getManufactures() {
        return new ManufacturesDaoImpl().getManufacture();
    }

    public List<Category> getCategories() {
        return new CategoriesDaoImpl().getCategories();
    }

    public List<GoodDao> getGoodsByName(String name) {
        return new GoodsDaoImpl().getGoods(name);
    }

    public List<GoodDao> getGoodsByCategory(String category) {
        return new GoodsDaoImpl().getGoodsByCategory(category);
    }

    public List<GoodDao> getGoodsByManufacture(String manufacture) {
        return new GoodsDaoImpl().getGoodsByManufacture(manufacture);
    }

}
