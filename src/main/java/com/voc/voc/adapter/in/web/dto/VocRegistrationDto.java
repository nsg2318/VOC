package com.voc.voc.adapter.in.web.dto;


import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.domain.Voc;
import lombok.AllArgsConstructor;
import lombok.Getter;


public class VocRegistrationDto {

    @Getter
    public static class Request {
        private Long supplierIndex;
        private Long carrierIndex;
        private Imputation imputation;
        private String reason;
        private Boolean claim;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Voc voc;
    }
}
