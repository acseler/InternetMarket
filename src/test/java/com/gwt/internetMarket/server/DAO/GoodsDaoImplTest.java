package com.gwt.internetMarket.server.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsDaoImplTest {

    private static GoodsDaoImpl goodsDao;

    @BeforeClass
    public static void goodDaoInit() {
        goodsDao = new GoodsDaoImpl();
    }

    @Test
    public void testGetGoodsByManufacture() throws Exception {
        assertEquals(1, goodsDao.getGoodsByManufacture("Fly").size());
    }

    @Test
    public void testGetGoodsByCategory() throws Exception {
        assertEquals(4, goodsDao.getGoodsByCategory("SmartTV").size());
    }

    @Test
    public void testGetGoods() throws Exception {
        assertEquals("LG 40UF670V", goodsDao.getGoods("LG 40UF670V").get(0).getName());
    }
}