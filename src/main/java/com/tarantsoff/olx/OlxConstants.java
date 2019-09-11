package com.tarantsoff.olx;

public interface OlxConstants {

    interface Selectors {

        String OFFERS_TABLE_PATH = "#offers_table > tbody > tr > td > div > table";
        String TITLE_PATH =     "tbody > tr:nth-child(1) > td.title-cell > div > h3 > a > strong";
        String PRICE_PATH =     "tbody > tr:nth-child(1) > td.wwnormal.tright.td-price > div > p > strong";
        String THUMB_PATH =     "tbody > tr:nth-child(1) > td:nth-child(1) > a > img";
        String HREF_PATH =      "tbody > tr:nth-child(1) > td.title-cell > div > h3 > a";
        String DISTRICT_PATH =  "tbody > tr:nth-child(2) > td.bottom-cell > div > p > small:nth-child(1) > span";
    }

    interface SearchQuery {

        String SINGLE_BEDROOM_RENT =
                "https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/kharkov/?search[order]=created_at:desc";
                //"https://www.olx.ua/nedvizhimost/kvartiry-komnaty/kharkov/q-%D1%81%D0%BD%D1%8F%D1%82%D1%8C-%D0%B4%D0%BE%D0%BC/";
    }

    interface Attributes {

        String DATA_ID_ATTR = "data-id";
        String SRC_ATTR = "src";
        String HREF_ATTR = "href";
    }
}
