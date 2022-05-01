package com.voc.voc.adapter.in.web.dto;

import com.voc.voc.domain.Compensation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class CompensationGetAllDto {

    @Getter
    @AllArgsConstructor
    public static class Response{
        List<Compensation> compensationList;
    }
}
