package org.esadev.mastermindhelper.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageUtils {
    public static String randomEmoji() {
        int start = 0x1F601;
        int end = 0x1F64F;
        int randomCodePoint = start + new Random().nextInt(end - start + 1);
        return new String(Character.toChars(randomCodePoint));
    }
}
