package ru.kornilov.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kornilov.entities.Domains;

public interface DomainRepo extends CrudRepository<Domains, Integer> {

}