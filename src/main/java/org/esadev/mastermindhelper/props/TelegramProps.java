package org.esadev.mastermindhelper.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "telegram")
public record TelegramProps(String token, String name, String chatId) {
}
