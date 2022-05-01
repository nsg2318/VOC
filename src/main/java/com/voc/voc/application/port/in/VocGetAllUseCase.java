package com.voc.voc.application.port.in;

import com.voc.voc.adapter.in.web.dto.VocGetAllDto;

public interface VocGetAllUseCase {
    VocGetAllDto.Response getAll();
}
