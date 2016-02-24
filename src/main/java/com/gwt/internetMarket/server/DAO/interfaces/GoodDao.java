package com.gwt.internetMarket.server.DAO.interfaces;

import com.gwt.internetMarket.server.DAO.HibernateEntity.Category;
import com.gwt.internetMarket.server.DAO.HibernateEntity.Good;
import com.gwt.internetMarket.server.DAO.HibernateEntity.Manufacture;

import java.util.List;

/**
 * Created by boduill on 24.02.16.
 */
public interface GoodDao {

    List<Good> getGoods(Manufacture manufacture);
    List<Good> getGoods(Category category);
    List<Good> getGoods(String name);
    List<Good> getGoods(int price);
    List<Good> getGoods(char avail);

}
