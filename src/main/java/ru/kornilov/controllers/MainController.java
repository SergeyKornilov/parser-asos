package ru.kornilov.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kornilov.entities.Domain;
import ru.kornilov.entities.Product;
import ru.kornilov.repos.DomainRepo;
import ru.kornilov.repos.ProductsRepo;
import ru.kornilov.service.DomainService;
import ru.kornilov.service.PageService;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProductsRepo productsRepo;
    @Autowired
    private PageService pageService;
    @Autowired
    private DomainService domainService;
    @Autowired
    private DomainRepo domainRepo;

    @GetMapping
    public String greeting(Map<String, Object> model) {

        Iterable<Product> products = productsRepo.findAll();
        model.put("products",products);

        return "main";
    }

    @GetMapping("/service")
    public String service(Map<String, Object> model){

        Iterable<Domain> domains = domainRepo.findAll();
        model.put("domains", domains);

        return "service";
    }
    @PostMapping("/service")
    public String parse(@RequestParam String url, /*String domainName,*/ Map<String, Object> model){

        if (url != null) {
            pageService.setUrlEnter(url);
            pageService.start();

//            Iterable<Product> products = productsRepo.findAll();
//            model.put("products", products);
        }

//        if (domainName != null){
//            domainService.addDomain(domainName);
//        }

        return "service";
    }
}