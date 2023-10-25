package org.esadev.mastermindhelper.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sheet")
public record SheetProps(String applicationName, String credentialsFilePath, String mastermindId) {
}
