package ru.kornilov.service;
/*
- принимает url и название региона
- возвразает url с параметрами для перехода на соответствующий регион
 */

import org.springframework.stereotype.Service;

@Service
public class SetRegion {

    public static String setRegion(String url, String region) {
        String urlRegion = "";
        StringBuilder stringBuilder;

        switch (region) {
            case ("Israel"):
                urlRegion = url + "&browseCountry=IL&browseCurrency=ILS";
                //        "https://www.asos.com/men/?browseCountry=IL&browseCurrency=ILS&xaffid=8779&r=1";
                break;
            case ("Taiwan"):
                urlRegion = url + "&browseCountry=TW&browseCurrency=TWD";
                //"https://www.asos.com/men/?browseCountry=TW&browseCurrency=TWD&xaffid=8779&r=1";
                break;
            case ("HongKong"):
                urlRegion = url + "&browseCountry=HK&browseCurrency=HKD";
                // "https://www.asos.com/men/?browseCountry=HK&browseCurrency=HKD&xaffid=8779&r=1";
                break;
            case ("China"):
                urlRegion = url + "&browseCountry=CN&browseCurrency=CNY";
                //"https://www.asos.com/men/?browseCountry=CN&browseCurrency=CNY&xaffid=8779&r=1";
                break;
            case ("UK"):
                urlRegion = url + "&browseCountry=GB&browseCurrency=GBP";
                //"https://www.asos.com/men/?browseCountry=GB&browseCurrency=GBP&xaffid=8779&r=1";
                break;
            case ("Turkey"):
                urlRegion = url + "&browseCountry=TR&browseCurrency=EUR";
                //"https://www.asos.com/men/?browseCountry=TR&browseCurrency=EUR&xaffid=8779&r=1";
                break;
            case ("Latvia"):
                urlRegion = url + "&browseCountry=LV&browseCurrency=EUR";
                break;

            case ("France"):
                stringBuilder = new StringBuilder(url);
                stringBuilder.insert(21, "fr/");
                urlRegion = String.valueOf(stringBuilder);
                break;
            case ("Russia"):
                stringBuilder = new StringBuilder(url);
                stringBuilder.insert(21, "ru/");
                urlRegion = String.valueOf(stringBuilder);
                break;

            case ("Australia"):
                stringBuilder = new StringBuilder(url);
                stringBuilder.insert(21, "au/");
                urlRegion = String.valueOf(stringBuilder);
                break;
            case ("US"):
                stringBuilder = new StringBuilder(url);
                stringBuilder.insert(21, "us/");
                urlRegion = String.valueOf(stringBuilder);
                break;
        }


        return urlRegion;
    }
}
