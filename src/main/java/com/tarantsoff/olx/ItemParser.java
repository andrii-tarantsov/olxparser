package com.tarantsoff.olx;

import com.tarantsoff.Item;
import org.jsoup.nodes.Element;

import static com.tarantsoff.olx.OlxConstants.Attributes.DATA_ID_ATTR;
import static com.tarantsoff.olx.OlxConstants.Attributes.HREF_ATTR;
import static com.tarantsoff.olx.OlxConstants.Attributes.SRC_ATTR;
import static com.tarantsoff.olx.OlxConstants.Selectors.*;

public class ItemParser {

    public Item parse(Element adItemInnerTable) {

        long dataId =
                Long.parseLong(adItemInnerTable.attr(DATA_ID_ATTR));
        String title =
                adItemInnerTable.selectFirst(TITLE_PATH).text();
        String price =
                adItemInnerTable.selectFirst(PRICE_PATH).text();
        String href =
                adItemInnerTable.selectFirst(HREF_PATH).absUrl(HREF_ATTR);
        String district =
                adItemInnerTable.selectFirst(DISTRICT_PATH).text();

        Element element = adItemInnerTable.selectFirst(THUMB_PATH);
        String thumb = element == null ? "" : element.attr(SRC_ATTR);

        return Item.builder()
                   .dataId(dataId)
                   .title(title)
                   .href(href)
                   .price(price)
                   .location(district)
                   .thumbSrc(thumb)
                   .build();
    }
}
