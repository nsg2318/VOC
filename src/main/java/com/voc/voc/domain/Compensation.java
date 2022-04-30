package com.voc.voc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * 배상 도메인
 */
@Value
@Getter
@AllArgsConstructor
public class Compensation {

    Identity compensationId;
    Voc voc;
    String amount;


}
