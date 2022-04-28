package com.voc.voc.application.port.in;

import com.voc.voc.adapter.in.web.dto.VocRegistrationDto;

public interface VocRegistrationUseCase {


    VocRegistrationDto.Response registration(VocRegistrationDto.Request request);
}
