package org.esadev.mastermindhelper.config;

import lombok.RequiredArgsConstructor;
import org.esadev.mastermindhelper.bot.MastermindHelperBot;
import org.esadev.mastermindhelper.props.TelegramProps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@RequiredArgsConstructor
public class TelegramConfig {
    private final TelegramProps telegramProps;

    @Bean
    public MastermindHelperBot mastermindHelperBot() {
        MastermindHelperBot mastermindHelperBot = new MastermindHelperBot(telegramProps.token(), telegramProps);
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(mastermindHelperBot);
        } catch (TelegramApiException e) {
        }
        return mastermindHelperBot;
    }
}
