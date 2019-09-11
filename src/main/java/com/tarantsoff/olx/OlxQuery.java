package com.tarantsoff.olx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class OlxQuery {
    public Document requestForOneBedrooms() {
        try {
            return Jsoup.connect(
                    "https://www.olx.ua/nedvizhimost/kvartiry-komnaty/kharkov/q-%D1%81%D0%BD%D1%8F%D1%82%D1%8C-%D0%B4%D0%BE%D0%BC/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
