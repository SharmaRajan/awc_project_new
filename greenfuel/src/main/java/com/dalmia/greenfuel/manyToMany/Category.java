


package com.dalmia.greenfuel.manyToMany;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_category")
public class Category {

    @Id
    @Column(name = "c_id")
    private String cId;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();


    public Category() {
    }

    public Category(String cId, String title) {
        this.cId = cId;
        this.title = title;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

