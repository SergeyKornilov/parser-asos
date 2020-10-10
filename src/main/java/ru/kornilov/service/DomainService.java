package ru.kornilov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kornilov.repos.DomainRepo;

@Service
public class DomainService {

    @Autowired
    DomainRepo domainRepo;

    public DomainService() {
    }

    public void addDomain(){

    }
}
