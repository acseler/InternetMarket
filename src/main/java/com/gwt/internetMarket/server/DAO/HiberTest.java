package com.gwt.internetMarket.server.DAO;

import org.apache.log4j.Logger;

/**
 * Created by boduill on 24.02.16.
 */
public class HiberTest {
    private static final Logger LOGGER = Logger.getLogger(HiberTest.class);

    public static void main(String[] args) {
        //Good dao impl test
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
//        LOGGER.debug("************ By name LG : " + goodsDao.getGoods("LG"));
//        LOGGER.debug("************ By category Smartphone : " +
//                goodsDao.getGoodsByCategory("Smartphone"));
//        LOGGER.debug("************ By price 11289 : " + goodsDao.getGoods(11289));
//        LOGGER.debug("************ By manufacture HTC : " + goodsDao.getGoodsByManufacture("HTC"));
//        LOGGER.debug("************ By avail y : " + Arrays.toString(goodsDao.getGoods('y').toArray()));
//        LOGGER.debug("************ By avail n : " + Arrays.toString(goodsDao.getGoods('n').toArray()));

        //Categories dao impl test
//        CategoriesDaoImpl categoriesDao = new CategoriesDaoImpl();
//        LOGGER.debug("************ All categories : " + Arrays.toString(categoriesDao.getCategories().toArray()));
//        LOGGER.debug("************ By name Smar : " + Arrays.toString(categoriesDao.getCategories("Smar").toArray()));
//        LOGGER.debug("************ By name Good : " + Arrays.toString(categoriesDao.getCategories("Good").toArray()));
//        LOGGER.debug("************ By name Pho : " + Arrays.toString(categoriesDao.getCategories("Pho").toArray()));

//        //Manufacture dao impl test
//        ManufactureDao manufactureDao = new ManufacturesDaoImpl();
//        LOGGER.debug("************ All manufactures : " + Arrays.toString(manufactureDao.getManufacture().toArray()));
//        LOGGER.debug("************ By name : " + Arrays.toString(manufactureDao.getManufacture("LG").toArray()));

    }
}
