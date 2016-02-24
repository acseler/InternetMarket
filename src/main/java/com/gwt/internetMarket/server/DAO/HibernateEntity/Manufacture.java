package com.gwt.internetMarket.server.DAO.HibernateEntity;

import javax.persistence.*;

/**
 * Created by boduill on 24.02.16.
 */

@Entity
@Table(name = "MANUFACTURES")
public class Manufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "M_NAME")
    private long mId;

    @Column(name = "M_NAME")
    private String mName;

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }
}
