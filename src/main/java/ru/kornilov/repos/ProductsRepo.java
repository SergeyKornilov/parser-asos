package ru.kornilov.repos;

import org.springframework.data.repository.CrudRepository;
import ru.kornilov.entities.Product;

public interface ProductsRepo extends CrudRepository<Product, Integer> {

}


