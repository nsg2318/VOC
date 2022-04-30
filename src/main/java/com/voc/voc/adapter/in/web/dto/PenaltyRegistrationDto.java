package com.voc.voc.adapter.in.web.dto;


import com.voc.voc.domain.Penalty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class PenaltyRegistrationDto {

    @Getter
    public static class Request {
        private Long vocIndex;
        private String amount;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Penalty penalty;
    }
}
