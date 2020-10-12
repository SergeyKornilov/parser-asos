package ru.kornilov.entities;

import javax.persistence.*;

@Entity
@Table(name = "Urls_categories")
public class UrlsCategories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "domainId")
    private Domain domain;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;


    @Column(name = "category_url")
    private String categoryUrl;

}