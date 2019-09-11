package com.tarantsoff.bot;

import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@Log4j2
public abstract class TarantsoffDemoBot extends TelegramLongPollingBot {

    static {
        ApiContextInitializer.init();
    }

    public String getBotUsername() {
        return "TarantsoffDemoBot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     *
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "886449662:AAF7WMJy6FGHtbhyxy50tItLruxsPq6kdaI";
    }

    public void run() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId id чата
     * @param s      Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(chatId);
        message.setText(s);
        try {
            //message.
            //sendMessage(message);
            this.execute(message);
        } catch (TelegramApiException e) {
            log.error(e);
        }
    }

}
