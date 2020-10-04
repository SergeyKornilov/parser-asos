package ru.kornilov.entities;

import javax.persistence.*;

@Entity
@Table(name = "Urls_categories")
public class UrlsCategories {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "domain_id")
    private String domainId;

    @Column(name = "category_url")
    private String categoryUrl;

}