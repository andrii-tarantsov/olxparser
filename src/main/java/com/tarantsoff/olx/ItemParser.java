package com.tarantsoff.olx;

import com.tarantsoff.Item;
import org.jsoup.nodes.Element;

public class ItemParser {

    public Item parse(Element houseRow) {

        String title =
                houseRow.selectFirst("tr:nth-child(1) > td.title-cell > div > h3 > a > strong").text();
        String price =
                houseRow.selectFirst("tr:nth-child(1) > td.wwnormal.tright.td-price > div > p > strong").text();
        String thumb =
                houseRow.selectFirst("tr:nth-child(1) > td:nth-child(1) > a > img").attr("src");
        String href =
                houseRow.selectFirst("tr:nth-child(1) > td.title-cell > div > h3 > a").absUrl("href");
        String location =
                houseRow.selectFirst("tr:nth-child(2) > td.bottom-cell > div > p > small:nth-child(1) > span").text();

        return Item.builder()
                   .title(title)
                   .href(href)
                   .price(price)
                   .location(location)
                   .thumbSrc(thumb)
                   .build();
    }
}
