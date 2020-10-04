package ru.kornilov.entities;

import javax.persistence.*;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "ru_price")
    private Double ruPrice;

    @Column(name = "au_price")
    private Double auPrice;

    @Column(name = "us_price")
    private Double usPrice;


}