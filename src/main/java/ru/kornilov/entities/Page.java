package ru.kornilov.entities;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class Page {
    private String url;
    private Document htmlCode;

    public Page() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Document getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(Document htmlCode) {
        this.htmlCode = htmlCode;
    }
}
