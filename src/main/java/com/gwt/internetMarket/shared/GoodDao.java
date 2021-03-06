package com.gwt.internetMarket.shared;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by boduill on 24.02.16.
 * Класс сущность для получения товара из БД
 */
@Entity
@Table(name = "GOODS")
public class GoodDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "G_ID")
    private long id;

    @Column(name = "G_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "C_ID")
    private CategoryDao category;

    @OneToOne
    @JoinColumn(name = "M_ID")
    private ManufactureDao manufacture;

    @Column(name = "G_PRICE")
    private int price;

    @Column(name = "G_DESCRIPTION", length = 1024)
    private String descriprion;

    //Can contains only 'y' or 'n' values
    @Column(name = "G_AVAIL")
    private char avail;

    @Column(name = "G_IMG")
    private String image;

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

    public CategoryDao getCategory() {
        return category;
    }

    public void setCategory(CategoryDao categoryDao) {
        this.category = categoryDao;
    }

    public ManufactureDao getManufacture() {
        return manufacture;
    }

    public void setManufacture(ManufactureDao manufactureDao) {
        this.manufacture = manufactureDao;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public char getAvail() {
        return avail;
    }

    public void setAvail(char avail) {
        this.avail = avail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", manufacture=" + manufacture +
                ", price=" + price +
                ", avail=" + avail +
                ", image='" + image + '\'' +
                '}';
    }
}
