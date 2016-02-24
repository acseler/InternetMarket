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
    private long id;

    @Column(name = "M_NAME")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
