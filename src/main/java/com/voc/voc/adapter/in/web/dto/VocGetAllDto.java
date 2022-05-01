package com.voc.voc.adapter.in.web.dto;

import com.voc.voc.domain.Voc;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class VocGetAllDto {

    @Getter
    @AllArgsConstructor
    public static class Response {
        List<Voc> vocList;
    }
}
