package com.voc.voc.application.port.in;

import com.voc.voc.adapter.in.web.dto.PenaltyObjectionDto;

public interface PenaltyUpdateUseCase {
    void updateRead(Long penaltyIndex);

    void updateObjection(Long penaltyIndex);

    void updateObjection(Long penaltyIndex, PenaltyObjectionDto.Request request);
}
