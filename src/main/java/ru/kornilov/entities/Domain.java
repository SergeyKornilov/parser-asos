package ru.kornilov.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name = "domains")
public class Domain {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_domain")
    private String nameDomain;

    public Domain(String nameDomain) {
        this.nameDomain = nameDomain;
    }

    public Domain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDomain() {
        return nameDomain;
    }

    public void setNameDomain(String nameDomain) {
        this.nameDomain = nameDomain;
    }
}