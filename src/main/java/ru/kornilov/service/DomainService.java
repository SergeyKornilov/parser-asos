package ru.kornilov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kornilov.entities.Domain;
import ru.kornilov.repos.DomainRepo;

@Service
public class DomainService {

    @Autowired
    DomainRepo domainRepo;

    public DomainService() {
    }

    public boolean addDomain(Domain domain){

        Domain domainFromDb = domainRepo.findByNameDomain(domain.getNameDomain());

        if (domainFromDb != null){
            return false;
        }

        domainRepo.save(domain);
        return true;
    }

    public boolean deleteDomain(String nameDomain){
        Domain domainFromDb = domainRepo.findByNameDomain(nameDomain);

        if (domainFromDb != null){
            domainRepo.delete(domainFromDb);
            return true;
        }
        return false;
    }

}
