package com.tarantsoff.olx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class OlxQuery {

    public Document requestForOneBedrooms() {
        try {
            return Jsoup.connect(
                    OlxConstants.SearchQuery.SINGLE_BEDROOM_RENT).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
