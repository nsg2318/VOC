package com.voc.voc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 배상 도메인
 */
@Getter
@AllArgsConstructor
public class Compensation {

    private final Identity compensationId;
    private final String amount;
    private Voc voc;


    public static Compensation newInstance(String amount, Voc voc) {
        return new Compensation(Identity.nothing(), amount, voc);
    }

    public Compensation(Identity compensationId, String amount) {
        this.compensationId = compensationId;
        this.amount = amount;
        this.voc = null;
    }
}
