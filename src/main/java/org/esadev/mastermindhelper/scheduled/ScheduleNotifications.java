package org.esadev.mastermindhelper.scheduled;

import static org.esadev.mastermindhelper.consts.Constants.SEND_DAILY_STATS;
import static org.esadev.mastermindhelper.consts.Constants.SEND_DAILY_TASK;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.esadev.mastermindhelper.entity.dto.LeaderInfoDto;
import org.esadev.mastermindhelper.service.DailyTaskService;
import org.esadev.mastermindhelper.service.MessageFormatService;
import org.esadev.mastermindhelper.service.SheetService;
import org.esadev.mastermindhelper.service.TelegramSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@EnableScheduling
@Service
@RequiredArgsConstructor
public class ScheduleNotifications {

  private final TelegramSender telegramSender;
  private final SheetService sheetService;
  private final MessageFormatService messageFormatService;
  private final DailyTaskService dailyTaskService;

  @Scheduled(cron = SEND_DAILY_STATS)
  public void sendSprintStatistics() throws TelegramApiException {
    List<LeaderInfoDto> info = sheetService.getLeadersInfo();
    String leadersInfo = messageFormatService.formatLeaderInfo(info);
    telegramSender.sendMessage(leadersInfo);
  }

  @Scheduled(cron = SEND_DAILY_TASK)
  public void sendDailyTask() throws TelegramApiException {
    if (LocalDate.now().isBefore(LocalDate.of(2024, 1, 1))) {
      var task = dailyTaskService.choose();
      if (task != null) {
        telegramSender.sendMessage(task);
      }
    }
  }

}
