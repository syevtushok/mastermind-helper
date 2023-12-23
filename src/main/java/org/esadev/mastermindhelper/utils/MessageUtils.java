package org.esadev.mastermindhelper.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageUtils {
    public static String leaderEmoji(int position) {
        return switch (position) {
            case 1 -> "🏆";
            case 2 -> "🥈";
            case 3 -> "🥉";
            default -> EMPTY;
        };
    }
}
