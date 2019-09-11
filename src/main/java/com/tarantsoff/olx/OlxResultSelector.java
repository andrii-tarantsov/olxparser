package com.tarantsoff.olx;

public interface OlxResultSelector {

    String OFFERS_TABLE_PATH = "#offers_table > tbody > tr > td > div > table";

    String TITLE_PATH =     "tbody > tr:nth-child(1) > td.title-cell > div > h3 > a > strong";

    String PRICE_PATH =     "tbody > tr:nth-child(1) > td.wwnormal.tright.td-price > div > p > strong";

    String THUMB_PATH =     "tbody > tr:nth-child(1) > td:nth-child(1) > a > img";

    String HREF_PATH =      "tbody > tr:nth-child(1) > td.title-cell > div > h3 > a";

    String LOCATION_PATH =  "tbody > tr:nth-child(2) > td.bottom-cell > div > p > small:nth-child(1) > span";
}
