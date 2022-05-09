package com.voc.voc.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;


/**
 * 페널티 도메인
 */
@Value
@Getter
@AllArgsConstructor
public class Penalty {

    Identity penaltyId;
    String amount;
    Boolean read;
    Boolean objection;
    String objectionReason;
    Voc voc;

    public static Penalty newInstance(Voc voc,String amount) {
        return new Penalty(Identity.nothing(), amount, false, false, "",voc);
    }


}
