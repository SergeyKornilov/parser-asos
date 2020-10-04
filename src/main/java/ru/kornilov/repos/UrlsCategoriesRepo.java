package ru.kornilov.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kornilov.entities.UrlsCategories;


public interface UrlsCategoriesRepo  extends CrudRepository<UrlsCategories, Integer> {
}
