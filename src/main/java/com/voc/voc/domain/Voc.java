package com.voc.voc.domain;

import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * VOC 도메인
 */
@Value
@Getter
@AllArgsConstructor
public class Voc {

    Identity vocId;
    VocStatus vocStatus;
    Supplier supplier;
    Carrier carrier;
    Compensation compensation;
    Penalty penalty;
    Imputation imputation;
    String reason;
    Boolean claim;

    public static Voc newInstance(Supplier supplier, Carrier carrier, Imputation imputation, String reason, Boolean claim) {
        return new Voc(Identity.nothing(), VocStatus.CLOSED, supplier, carrier, null, null, imputation, reason, claim);
    }

}
