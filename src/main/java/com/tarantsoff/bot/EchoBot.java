package com.tarantsoff.bot;

import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
public class EchoBot extends TarantsoffDemoBot {

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }
}
