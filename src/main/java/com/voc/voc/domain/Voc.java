package com.voc.voc.domain;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;


@Value
@Getter
public class Voc {


    VocId id;
    Supplier supplier;
    Carrier carrier;
    Imputation imputation;
    VocStatus vocStatus;
    String reason;
    Boolean claim;
    Compensation compensation;

    @Builder
    public Voc(VocId id, Supplier supplier, Carrier carrier, Imputation imputation, VocStatus vocStatus, String reason, Boolean claim, Compensation compensation) {
        this.id = id;
        this.supplier = supplier;
        this.carrier = carrier;
        this.imputation = imputation;
        this.vocStatus = vocStatus;
        this.reason = reason;
        this.claim = claim;
        this.compensation = compensation;
    }


    @AllArgsConstructor
    public static class VocId {
        Long id;
    }

}
