package com.tarantsoff.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class EchoMessage {

    SendMessage getMessage(Long chatId, String text){
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId);
        message.setText(text);
        return message;
    }
}
