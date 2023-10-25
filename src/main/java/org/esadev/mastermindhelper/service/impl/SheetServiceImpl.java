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
        for (int i = 0; i < values.size(); i++) {
            List<Object> row = values.get(i);
            LeaderInfoDto leaderInfoDto = LeaderInfoDto.builder().position(i + 1).name(row.get(0).toString().trim()).percent(row.get(1).toString().trim()).build();
            leaderInfoDtos.add(leaderInfoDto);
        }
        return leaderInfoDtos;
    }
}
