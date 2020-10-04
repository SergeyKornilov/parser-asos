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
если url картинки пустой парсим картинку со страницы товара
 */

@Service
public class ImgService {

    @Autowired
    ProductsRepo productsRepo;

    public ImgService() {
    }

    public void checkImg(){
        List<Product> products = (ArrayList) productsRepo.findAll();                                                        //выгружаем все товары

        for (Product product :                                                                                              //проходим по товарам
                products) {

                if (product.getUrlImg().equals("")) {                                                                       //если url картинки пустой
                    product.setUrlImg(updateImg(product.getProductUrl()));
                    productsRepo.save(product);
                }
            }
    }

    private String updateImg(String productUrl){
        Document htmlProduct = null;

        try {
            htmlProduct = Jsoup.parse(new URL(productUrl), 10000);                                                //парсим страницу
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements code = htmlProduct.select("div.product-carousel>img");                                              //достаем img

        System.out.println(code.attr("src"));
        return code.attr("src");                                                                                   //возвращаем ссылку
    }
}