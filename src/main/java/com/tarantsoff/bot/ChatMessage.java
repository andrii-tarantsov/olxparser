package com.tarantsoff.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface ChatMessage {
    SendMessage getMessage(Long chatId);
}
