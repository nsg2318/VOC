package com.voc.voc.adapter.in.web.dto;

import com.voc.voc.domain.Voc;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class VocGetAllDto {

    @Getter
    @AllArgsConstructor
    public static class Response {
        // TODO: 2022/05/09 Voc -> Custom Response
        List<Voc> vocList;
    }
}
