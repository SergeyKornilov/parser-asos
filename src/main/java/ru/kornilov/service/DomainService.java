package ru.kornilov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kornilov.entities.Domains;
import ru.kornilov.repos.DomainRepo;

@Service
public class DomainService {

    @Autowired
    DomainRepo domainRepo;

    @Autowired
    Domains domains;

    public DomainService() {
    }

    public void addDomain(String name){

        domains.setNameDomain(name);
        domainRepo.save(domains);

    }
}
