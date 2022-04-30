package com.voc.voc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class Compensation {

    CompensationId compensationId;
    String amount;

    @AllArgsConstructor
    @Getter
    public static class CompensationId {
        Long id;
    }


}
