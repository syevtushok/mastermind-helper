package org.esadev.mastermindhelper.bot;

import lombok.RequiredArgsConstructor;
import org.esadev.mastermindhelper.props.TelegramProps;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
public class MastermindHelperBot extends TelegramLongPollingBot {
    private final TelegramProps telegramProps;

    public MastermindHelperBot(String botToken, TelegramProps telegramProps) {
        super(botToken);
        this.telegramProps = telegramProps;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public String getBotUsername() {
        return telegramProps.name();
    }

}