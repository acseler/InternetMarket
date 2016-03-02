package com.gwt.internetMarket.server.DAO;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoriesDaoImplTest {

    private static CategoriesDaoImpl categoriesDao;

    @BeforeClass
    public static void categoryDaoInit() {
        categoriesDao = new CategoriesDaoImpl();
    }

    @Test
    public void testGetCategories() throws Exception {
        assertEquals(2, categoriesDao.getCategories().size());
    }

    @Test
    public void testGetCategories1() throws Exception {
        assertEquals("TV", categoriesDao.getCategory("TV").getName());
    }
}