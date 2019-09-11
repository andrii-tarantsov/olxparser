package com.tarantsoff.bot;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RealEstateBot extends TarantsoffDemoBot {
    public void onUpdateReceived(Update update) {
/*
        String message =
                "https://telegra.ph/Dzhembe-Indijskij-baraban-ruchnoj-raboty-09-06";
        sendMsg(update.getMessage().getChatId().toString(), message);
*/

        try {
            if (update.hasMessage()) {
                doMessage(update);
            } else if (update.hasCallbackQuery()) {
                System.out.println("callback!!!: " + update);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void doMessage(Update update) throws TelegramApiException {
        String messageText = update.getMessage().getText();
        if (messageText.equals("/квартиры")) {
            showAppartmentsMenu(update.getMessage().getChatId());
        } else if (messageText.equals("/дома")) {
            showHousesMenu(update.getMessage().getChatId());
        } else if (messageText.equals("Однокомнатные")) {
            System.out.println("1k");
        } else if (messageText.equals("Двухкомнатные")) {
            System.out.println("2k");
        } else {
            Message incommingMessage = update.getMessage();

            echo(incommingMessage.getChatId(), incommingMessage.getText());
        }
    }

    void showAppartmentsMenu(Long chatId) throws TelegramApiException {

        KeyboardMessage keyboardMessage = new KeyboardMessage();

        sendApiMethod(keyboardMessage.getMessage(chatId));
    }

    void showHousesMenu(Long chatId) throws TelegramApiException {

        KeyboardMessage2 keyboardMessage2 = new KeyboardMessage2();

        sendApiMethod(keyboardMessage2.getMessage(chatId));
    }

    void echo(Long chatId, String text) throws TelegramApiException {

        EchoMessage echoMessage = new EchoMessage();
        sendApiMethod(echoMessage.getMessage(chatId, text));
    }
}
