package com.gwt.internetMarket.server.DAO;

import com.gwt.internetMarket.shared.ManufactureDao;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManufacturesDaoImplTest {

    private static ManufacturesDaoImpl manufactureDao;

    @BeforeClass
    public static void manufactureDaoInit() {
        manufactureDao = new ManufacturesDaoImpl();
    }

    @Test
    public void testGetManufacture() throws Exception {
        assertEquals("Philips", manufactureDao.getManufacture("Philips").getName());
    }

    @Test
    public void testGetManufacture1() throws Exception {
        assertEquals(10, manufactureDao.getManufacture().size());
    }
}