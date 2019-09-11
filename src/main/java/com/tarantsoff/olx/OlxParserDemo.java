package com.tarantsoff.olx;

import com.tarantsoff.Item;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class OlxParserDemo {

    public static void main(String[] args) throws IOException {

        Document doc = new OlxQuery().requestForOneBedrooms();

        ResultsPageParser resultsPageParser = new ResultsPageParser(new ItemParser());

        List<Item> items = resultsPageParser.parse(doc);

        ItemPrinter printer = new ItemPrinter(System.out);
        items.forEach(printer::print);
    }
}
