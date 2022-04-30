package com.voc.voc.application.port.in;

import com.voc.voc.adapter.in.web.dto.PenaltyRegistrationDto;

public interface PenaltyRegistrationUseCase {

    PenaltyRegistrationDto.Response registration(PenaltyRegistrationDto.Request request);
}
