package ru.kornilov.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "domains")
public class Domains {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_domain")
    private String nameDomain;

    public Domains(String nameDomain) {
        this.nameDomain = nameDomain;
    }

    public Domains() {
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