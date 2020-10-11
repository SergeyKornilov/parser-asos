package ru.kornilov.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kornilov.entities.Product;
import ru.kornilov.repos.ProductsRepo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
if img`s url is null, parse img from product`s page
 */

@Service
public class ImgService {

    @Autowired
    ProductsRepo productsRepo;

    public ImgService() {
    }

    public void checkImg(){
        List<Product> products = (List<Product>) productsRepo.findAll();                                                        //get all products

        for (Product product :
                products) {

                if (product.getUrlImg().equals("")) {
                    product.setUrlImg(updateImg(product.getProductUrl()));
                    productsRepo.save(product);
                }
            }
    }

    private String updateImg(String productUrl){
        Document htmlProduct = null;

        try {
            htmlProduct = Jsoup.parse(new URL(productUrl), 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }


        assert htmlProduct != null;
        Elements code = htmlProduct.select("div.product-carousel>img");

        System.out.println(code.attr("src"));
        return code.attr("src");
    }
}