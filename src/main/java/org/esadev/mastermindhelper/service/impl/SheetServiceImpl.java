package org.esadev.mastermindhelper.service.impl;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.esadev.mastermindhelper.config.SheetConfig;
import org.esadev.mastermindhelper.entity.dto.LeaderInfoDto;
import org.esadev.mastermindhelper.props.SheetProps;
import org.esadev.mastermindhelper.service.SheetService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.esadev.mastermindhelper.consts.Constants.LEADERS_RANGE;
import static org.esadev.mastermindhelper.consts.Constants.NO_DATA;

@Service
@RequiredArgsConstructor
@Log4j2
public class SheetServiceImpl implements SheetService {
    private final SheetProps sheetProps;
    private final SheetConfig sheetConfig;

    @Override
    public List<LeaderInfoDto> getLeadersInfo() {
        try {
            ValueRange valueRange = getValues().get(sheetProps.mastermindId(), LEADERS_RANGE).execute();
            List<List<Object>> values = valueRange.getValues();
            return getLeadersInfo(values);
        } catch (Exception e) {
            log.throwing(e);
        }
        return List.of();
    }

    private Sheets.Spreadsheets.Values getValues() throws Exception {
        return sheetConfig.getSheetsService().spreadsheets().values();
    }

    private List<LeaderInfoDto> getLeadersInfo(List<List<Object>> values) {
        List<LeaderInfoDto> leaderInfoDtos = new ArrayList<>();
        int position = 1;
        for (var row : values) {
            String percent = row.get(1).toString().trim();
            if (!percent.equals(NO_DATA)) {
                LeaderInfoDto leaderInfoDto = LeaderInfoDto.builder()
                        .position(position++)
                        .name(row.getFirst().toString().trim())
                        .percent(percent)
                        .build();
                leaderInfoDtos.add(leaderInfoDto);
            }
      }
        return leaderInfoDtos;
    }
}
