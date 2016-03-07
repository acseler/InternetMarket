package com.gwt.internetMarket.shared;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by boduill on 24.02.16.
 * Класс сущность для получения производителя из БД
 */

@Entity
@Table(name = "MANUFACTURES")
public class ManufactureDao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "M_ID")
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

    @Override
    public String toString() {
        return "Manufacture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
