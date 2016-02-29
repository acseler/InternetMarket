package com.gwt.internetMarket.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boduill on 26.02.16.
 */
public class Category implements Serializable {
    private long id;
    private String name;
    private long pId;
    private List<String> subCategories = new ArrayList<String>();

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

    public List<String> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<String> subCategories) {
        this.subCategories = subCategories;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pId=" + pId +
                ", subCategories=" + subCategories +
                '}';
    }
}
