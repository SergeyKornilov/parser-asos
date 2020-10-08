package ru.kornilov.service.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    public CategoryService() {
    }

    public List<String> getCategoryUrls(String url){
        List<String> urlsPages = new ArrayList<>();
        double numPages;

        Document page = null;
        try {
            page = Jsoup.parse(new URL(url), 10000);
        } catch (IOException e) {
            e.printStackTrace();
        }


        assert page != null;
        Elements numberOnPage = page.select("p._2JQRAAs");                             //"вы просмотрели .. из .."

        String strNumberProd = numberOnPage.text().replaceAll("\\D", "");
        numPages = Math.ceil(Double.parseDouble(strNumberProd) / 72);                           //72 - количество товаров на 1 стр

        urlsPages.add(url);

        for (int i = 2; i <= numPages; i++) {
            urlsPages.add(url + "&page=" + i);                                                                          //Остальные URL получаем и добавляем
        }

        return urlsPages;
    }
}