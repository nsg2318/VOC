package com.voc.voc.domain;

import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@AllArgsConstructor
public class Voc {

    VocId vocId;
    VocStatus vocStatus;
    Supplier supplier;
    Carrier carrier;
    Compensation compensation;
    Imputation imputation;
    String reason;
    Boolean claim;


    @AllArgsConstructor
    @Getter
    public static class VocId {
        Long id;
    }

    public static Voc newInstance(Supplier supplier, Carrier carrier, Imputation imputation, String reason, Boolean claim) {
        return new Voc(null, VocStatus.OPEN, supplier, carrier, null, imputation, reason, claim);
    }
}
