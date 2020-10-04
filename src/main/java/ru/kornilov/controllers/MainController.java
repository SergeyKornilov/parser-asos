package ru.kornilov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kornilov.entities.Product;
import ru.kornilov.repos.ProductsRepo;
import ru.kornilov.service.PageService;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProductsRepo productsRepo;
    @Autowired
    private PageService pageService;

    @GetMapping
    public String greeting(Map<String, Object> model) {

        Iterable<Product> products = productsRepo.findAll();
        model.put("products",products);

        return "main";
    }

    @GetMapping("/service")
    public String service(Map<String, Object> model){
        return "service";
    }
    @PostMapping("/service")
    public String parse(@RequestParam String url, Map<String, Object> model){

        pageService.setUrlEnter(url);
        pageService.start();

        Iterable<Product> products = productsRepo.findAll();
        model.put("products",products);

        return "main";

    }
}