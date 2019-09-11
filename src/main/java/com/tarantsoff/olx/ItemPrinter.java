package com.tarantsoff.olx;

import com.tarantsoff.Item;
import lombok.RequiredArgsConstructor;

import java.io.PrintStream;

@RequiredArgsConstructor
public class ItemPrinter {

    private final PrintStream printer;

    public void print(Item item) {
        StringBuilder message = new StringBuilder();
        message
                .append(item.getTitle()).append("\n")
                .append("\t* ").append(item.getLocation()).append("\n")
                .append("\t* ").append(item.getPrice()).append("\n")
                .append("\t* ").append(item.getLocation()).append("\n")
                .append("\t* ").append(item.getHref()).append("\n")
        ;
        printer.println(message.toString());
    }
}
