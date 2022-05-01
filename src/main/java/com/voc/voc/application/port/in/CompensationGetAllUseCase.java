package com.voc.voc.application.port.in;

import com.voc.voc.adapter.in.web.dto.CompensationGetAllDto;

public interface CompensationGetAllUseCase {
    CompensationGetAllDto.Response getAllCompensation();
}
