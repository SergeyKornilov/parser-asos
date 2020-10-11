package ru.kornilov.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kornilov.entities.Domain;

public interface DomainRepo extends CrudRepository<Domain, Integer> {
    Domain findByNameDomain(String nameDomain);
    Domain findById(int id);

}