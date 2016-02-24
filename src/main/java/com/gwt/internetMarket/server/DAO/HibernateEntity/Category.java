package com.gwt.internetMarket.server.DAO.HibernateEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by boduill on 15.02.16.
 */
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "C_ID")
    private long id;

    @Column(name = "C_NAME")
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "P_ID")
    private Category category;

    @OneToMany(mappedBy = "category")
    private Set<Category> subCategories = new HashSet<Category>();

    public long getcId() {
        return id;
    }

    public void setcId(long cId) {
        this.id = cId;
    }

    public String getcName() {
        return name;
    }

    public void setcName(String cName) {
        this.name = cName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (!name.equals(category.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
