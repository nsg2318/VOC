package com.voc.voc.adapter.in.web.dto;


import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class VocRegistrationDto {

    @Getter
    public static class Request {
        private Long supplierIndex;
        private Long carrierIndex;
        private Imputation imputation;
        private String reason;
    }

    @AllArgsConstructor
    public static class Response {
        private VocEntity vocEntity;
    }
}
