package com.tarantsoff;

import com.tarantsoff.olx.ItemParser;
import com.tarantsoff.olx.OlxQuery;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class ItemParserTest {
    @Test
    public void testParse(){
        Document doc = new OlxQuery().requestForOneBadrooms();

        Elements results = doc.select(
                "#offers_table > tbody > tr > td > div > table > tbody");
        ItemParser itemParser = new ItemParser();
        List<Item> items = results
                .stream()
                .map(itemParser::parse)
                .collect(Collectors.toList());
        for (Item item : items) {
            Assertions.assertNotNull(item.getLocation());
            Assertions.assertNotNull(item.getHref());
            Assertions.assertNotNull(item.getPrice());
            Assertions.assertNotNull(item.getTitle());
            Assertions.assertNotNull(item.getThumbSrc());

            Assertions.assertTrue(item.getDataId() != 0);
        }


    }
}
