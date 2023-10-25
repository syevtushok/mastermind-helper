package org.esadev.mastermindhelper.service;


import org.esadev.mastermindhelper.entity.dto.LeaderInfoDto;

import java.util.List;

public interface SheetService {
    List<LeaderInfoDto> getLeadersInfo();
}
