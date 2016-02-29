package com.gwt.internetMarket.shared;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by boduill on 15.02.16.
 */
@Entity
@Table(name = "CATEGORIES")
public class CategoryDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID")
    private long id;

    @Column(name = "C_NAME")
    private String name;

    @Column(name = "P_ID")
    private long pId;

    public long getId() {
        return id;
    }

    public void setId(long cId) {
        this.id = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String cName) {
        this.name = cName;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDao categoryDao = (CategoryDao) o;

        if (id != categoryDao.id) return false;
        if (!name.equals(categoryDao.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
