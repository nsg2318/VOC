package com.voc.voc.application.port.in;

import com.voc.voc.adapter.in.web.dto.CompensationRegistrationDto;

public interface CompensationRegistrationUseCase {

    CompensationRegistrationDto.Response registration(CompensationRegistrationDto.Request request);
}
