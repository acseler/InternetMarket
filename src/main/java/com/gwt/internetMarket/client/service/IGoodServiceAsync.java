package com.gwt.internetMarket.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.internetMarket.shared.GoodDao;
import com.gwt.internetMarket.shared.ManufactureDao;
import com.gwt.internetMarket.shared.Category;

import java.util.List;

/**
 * Created by boduill on 25.02.16.
 */
public interface IGoodServiceAsync {
    void getManufactures(AsyncCallback<List<ManufactureDao>> callback);
    void getCategories(AsyncCallback<List<Category>> callback);
    void getGoodsByName(String name, AsyncCallback<List<GoodDao>> callback);
    void getGoodsByCategory(String category, AsyncCallback<List<GoodDao>> callback);
    void getGoodsByManufacture(String manufacture, AsyncCallback<List<GoodDao>> callback);
}
