package com.tarantsoff;

import com.tarantsoff.olx.ItemParser;
import com.tarantsoff.olx.OlxQuery;
import com.tarantsoff.olx.ResultsPageParser;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ItemParserTest {
    @Test
    public void testParse(){
        Document doc = new OlxQuery().requestForOneBadrooms();

        ResultsPageParser resultsPageParser = new ResultsPageParser(new ItemParser());

        List<Item> items = resultsPageParser.parse(doc);

    }
}
