package ru.kornilov.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kornilov.entities.Category;

public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
