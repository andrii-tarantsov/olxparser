package com.tarantsoff.olx;

import com.tarantsoff.Item;
import org.jsoup.nodes.Element;

public class ItemParser {

    public Item parse(Element adItemInnerTable) {

        long dataId =
                Long.parseLong(adItemInnerTable.attr("data-id"));
        String title =
                adItemInnerTable.selectFirst(OlxResultSelector.TITLE_PATH).text();
        String price =
                adItemInnerTable.selectFirst(OlxResultSelector.PRICE_PATH).text();
        String thumb =
                adItemInnerTable.selectFirst(OlxResultSelector.THUMB_PATH).attr("src");
        String href =
                adItemInnerTable.selectFirst(OlxResultSelector.HREF_PATH).absUrl("href");
        String location =
                adItemInnerTable.selectFirst(OlxResultSelector.LOCATION_PATH).text();

        return Item.builder()
                   .dataId(dataId)
                   .title(title)
                   .href(href)
                   .price(price)
                   .location(location)
                   .thumbSrc(thumb)
                   .build();
    }
}
