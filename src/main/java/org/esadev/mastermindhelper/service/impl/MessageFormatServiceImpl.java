package org.esadev.mastermindhelper.service.impl;

import org.esadev.mastermindhelper.entity.dto.LeaderInfoDto;
import org.esadev.mastermindhelper.service.MessageFormatService;
import org.esadev.mastermindhelper.utils.MessageUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.esadev.mastermindhelper.consts.Constants.*;

@Service
public class MessageFormatServiceImpl implements MessageFormatService {
    @Override
    public String formatLeaderInfo(List<LeaderInfoDto> info) {
        StringBuilder builder = new StringBuilder(String.format(LEADER_INFO_FIRST_LINE_MESSAGE, LocalDate.now()));

        if (info.isEmpty()) {
            builder.append(NO_LEADER_INFO_MESSAGE);
            return builder.toString();
        }

        info.stream()
                .map(leader -> String.format(LEADER_INFO_BUILD_LINE_MESSAGE, leader.getPosition(), leader.getName(), leader.getPercent(), MessageUtils.randomEmoji()))
                .forEach(builder::append);
        return builder.toString();
    }
}
