package ru.kornilov.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_category")
    private String nameCategory;

    @Column(name = "url_category")
    private String urlCategory;
}