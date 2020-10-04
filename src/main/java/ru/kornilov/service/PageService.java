package ru.kornilov.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kornilov.entities.Page;
import ru.kornilov.entities.Product;
import ru.kornilov.repos.ProductsRepo;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PageService    extends Thread {

    @Autowired
    private ImgService imgService;

    @Autowired
    private Page page;

    @Autowired
    ProductsRepo productsRepo;

    public String getUrlEnter() {
        return urlEnter;
    }

    public void setUrlEnter(String urlEnter) {
        this.urlEnter = urlEnter;
    }

    private String urlEnter;

    public PageService() {
    }

    public void run(){
        parsePage();
    }

    Elements productCartHtml;


    public void parsePage(){

        try {
            page.setHtmlCode(Jsoup.parse(new URL(urlEnter), 10000));
        } catch (IOException e) {
            e.printStackTrace();
        }
        productCartHtml = page.getHtmlCode().select("a._3TqU78D");

        for (Element e :
                productCartHtml) {

            Product product = new Product();

            product.setName(e.getElementsByClass("_3J74XsK").text());

            product.setProductUrl(e.attr("href"));                                                                  //получаем ссылку на товар

            Pattern pattern = Pattern.compile("prd.+\\?");                                                                      //достаем строку "prd/*код_товара*/?"
            Matcher matcher = pattern.matcher(product.getProductUrl());

            while (matcher.find()) {
                product.setProductCode(product.getProductUrl().substring(matcher.start(), matcher.end()).replaceAll("\\D", ""));        //оставляем только цифры
            }

            product.setUrlImg(e.getElementsByClass("_2r9Zh0W").attr("src"));

            product.setDateAdd(new Date());


            //заглушка
            product.setIdCategory("test");

            productsRepo.save(product);
        }
        imgService.checkImg();
    }

}