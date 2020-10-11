package ru.kornilov.entities;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity


@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "name")
    private String name;

    @Column(name = "date_add")
    private Date dateAdd;

    @Column(name = "id_category")
    private String idCategory;

    @Column(name = "product_url")
    private String productUrl;

    @Column(name = "Url_img")
    private String urlImg;


    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public Product() {
    }

    public Product(String productCode, String name, Date dateAdd, String idCategory, String urlImg) {
        this.productCode = productCode;
        this.name = name;
        this.dateAdd = dateAdd;
        this.idCategory = idCategory;
        this.urlImg = urlImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}