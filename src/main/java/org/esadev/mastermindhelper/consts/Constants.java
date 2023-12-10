package org.esadev.mastermindhelper.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String LEADERS_RANGE = "Спринт!V2:W7";
    public static final String SEND_DAILY_STATS = "0 0 6 * * *";
    public static final String SEND_DAILY_TASK = "* * 4 * * *";
    public static final String NO_LEADER_INFO_MESSAGE = "`З якоїсь причини не можу отримати інформацію. Зверніться в підтримку";
    public static final String LEADER_INFO_FIRST_LINE_MESSAGE = "**Статистика на %s**\n\n";
    public static final String LEADER_INFO_BUILD_LINE_MESSAGE = "`%s місце - %s => %s \uD83E\uDD1F \n`";

}
