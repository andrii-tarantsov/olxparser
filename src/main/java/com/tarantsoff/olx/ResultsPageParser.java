package com.tarantsoff.olx;

import com.tarantsoff.Item;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ResultsPageParser {

    private final ItemParser itemParser;

    public List<Item> parse(Document document) {

        Elements results = document.select(
                "#offers_table > tbody > tr > td > div > table > tbody");
        return results
                .stream()
                .map(itemParser::parse)
                .collect(Collectors.toList());
    }
}
