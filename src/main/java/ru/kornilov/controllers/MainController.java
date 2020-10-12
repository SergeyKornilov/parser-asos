package ru.kornilov.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kornilov.entities.Category;
import ru.kornilov.entities.Domain;
import ru.kornilov.entities.Product;
import ru.kornilov.repos.CategoryRepo;
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
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping
    public String greeting(Map<String, Object> model) {

        Iterable<Product> products = productsRepo.findAll();
        model.put("products",products);

        return "main";
    }

    @GetMapping("/service")
    public String service(Map<String, Object> model){


        Iterable<Category> categories = categoryRepo.findAll();
        model.put("categories", categories);
        Iterable<Domain> domains = domainRepo.findAll();
        model.put("domains", domains);

        return "service";
    }
    @PostMapping("/service")
    public String parse(@RequestParam String url,
                        @RequestParam String domainName,
                        Map<String, Object> model){
        if (url.equals("")) {                                                                        //???логика в контроллере
            pageService.setUrlEnter(url);
            pageService.start();
        }

        if (domainName.equals("")) {
            Domain domain = new Domain();
            domain.setNameDomain(domainName);
            domainService.addDomain(domain);
        }

        Iterable<Domain> domains = domainRepo.findAll();
        model.put("domains", domains);

        return "service";
    }

    @GetMapping("/service/delete")
    public String deleteDomain(@ModelAttribute("name") String nameDomain, Map<String, Object> model){

        domainService.deleteDomain(nameDomain);

        return "redirect:/service";
    }

    @GetMapping("/service/domain-form")
    public String domainForm(@ModelAttribute("id") int idDomain, Map<String, Object> model){

            model.put("domain", domainRepo.findById(idDomain));

        return "domain-form";
    }
}