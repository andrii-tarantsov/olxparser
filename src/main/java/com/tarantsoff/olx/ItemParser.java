package com.tarantsoff.olx;

import com.tarantsoff.Item;
import org.jsoup.nodes.Element;

import static com.tarantsoff.olx.OlxConstants.Selectors.*;

public class ItemParser {

    public Item parse(Element adItemInnerTable) {

        long dataId =
                Long.parseLong(adItemInnerTable.attr("data-id"));
        String title =
                adItemInnerTable.selectFirst(TITLE_PATH).text();
        String price =
                adItemInnerTable.selectFirst(PRICE_PATH).text();
        String thumb =
                adItemInnerTable.selectFirst(THUMB_PATH).attr("src");
        String href =
                adItemInnerTable.selectFirst(HREF_PATH).absUrl("href");
        String location =
                adItemInnerTable.selectFirst(LOCATION_PATH).text();

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
