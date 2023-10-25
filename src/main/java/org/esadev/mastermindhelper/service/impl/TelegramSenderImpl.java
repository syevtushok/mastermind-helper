package org.esadev.mastermindhelper.service.impl;

import lombok.RequiredArgsConstructor;
import org.esadev.mastermindhelper.bot.MastermindHelperBot;
import org.esadev.mastermindhelper.props.TelegramProps;
import org.esadev.mastermindhelper.service.TelegramSender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
@RequiredArgsConstructor
public class TelegramSenderImpl implements TelegramSender {
    private final MastermindHelperBot telegramBot;
    private final TelegramProps telegramProps;

    @Override
    public void sendMessage(String messageText) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(telegramProps.chatId());
        sendMessage.setText(messageText);
        sendMessage.setAllowSendingWithoutReply(true);
        sendMessage.enableMarkdown(true);

        telegramBot.execute(sendMessage);
    }

}
