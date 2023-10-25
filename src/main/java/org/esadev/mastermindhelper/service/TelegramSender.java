package org.esadev.mastermindhelper.service;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface TelegramSender {
    void sendMessage(String messageText) throws TelegramApiException;
}
