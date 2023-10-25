package org.esadev.mastermindhelper.scheduled;

import lombok.RequiredArgsConstructor;
import org.esadev.mastermindhelper.entity.dto.LeaderInfoDto;
import org.esadev.mastermindhelper.service.MessageFormatService;
import org.esadev.mastermindhelper.service.SheetService;
import org.esadev.mastermindhelper.service.TelegramSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import static org.esadev.mastermindhelper.consts.Constants.SEND_DAILY_STATS;

@EnableScheduling
@Service
@RequiredArgsConstructor
public class ScheduleNotifications {
    private final TelegramSender telegramSender;
    private final SheetService sheetService;
    private final MessageFormatService messageFormatService;

    @Scheduled(cron = SEND_DAILY_STATS)
    public void sendSprintStatistics() throws TelegramApiException {
        List<LeaderInfoDto> info = sheetService.getLeadersInfo();
        String leadersInfo = messageFormatService.formatLeaderInfo(info);
        telegramSender.sendMessage(leadersInfo);
    }

}
