package com.tarantsoff;

import com.tarantsoff.olx.ItemParser;
import com.tarantsoff.olx.OlxQuery;
import com.tarantsoff.olx.OlxResultSelector;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemParserTest {
    @Test
    public void testParse(){
        Document doc = new OlxQuery().requestForOneBadrooms();

        Elements results = doc.select(OlxResultSelector.OFFERS_TABLE_PATH);
        ItemParser itemParser = new ItemParser();
        List<Item> items = results
                .stream()
                .map(itemParser::parse)
                .collect(Collectors.toList());
        for (Item item : items) {
            assertNotNull(item.getLocation());
            assertNotNull(item.getHref());
            assertNotNull(item.getPrice());
            assertNotNull(item.getTitle());
            assertNotNull(item.getThumbSrc());

            // assertTrue(item.getDataId() != 0);
        }

    }
}
