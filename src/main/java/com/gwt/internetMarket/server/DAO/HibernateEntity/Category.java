package com.gwt.internetMarket.server.DAO.HibernateEntity;

import javax.persistence.*;

/**
 * Created by boduill on 15.02.16.
 */
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID")
    private long cId;

    @Column(name = "C_NAME")
    private String cName;

    @Column(name = "P_ID")
    private long pId;

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }
}
