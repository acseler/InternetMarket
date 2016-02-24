package com.gwt.internetMarket.server.DAO.HibernateEntity;

import javax.persistence.*;

/**
 * Created by boduill on 24.02.16.
 */
@Entity
@Table(name = "GOODS")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "G_ID")
    private long id;

    @Column(name = "G_NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "C_ID")
    private Category category;

    @OneToOne
    @JoinColumn(name = "M_ID")
    private Manufacture manufacture;

    @Column(name = "G_PRICE")
    private int price;

    @Column(name = "G_DESCRIPTION")
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
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
}
