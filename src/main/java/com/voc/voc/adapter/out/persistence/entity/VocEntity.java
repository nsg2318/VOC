package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "voc")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private VocStatus vocStatus;

    @OneToOne
    @JoinColumn(name = "supplier")
    private SupplierEntity supplierEntity;

    @OneToOne
    @JoinColumn(name = "carrier")
    private CarrierEntity carrierEntity;

    @NotNull
    private Imputation imputation;

    @NotNull
    @Size(max = 255)
    private String reason;

    @Builder
    public VocEntity(VocStatus vocStatus, SupplierEntity supplierEntity, CarrierEntity carrierEntity, Imputation imputation, String reason) {
        this.vocStatus = vocStatus;
        this.supplierEntity = supplierEntity;
        this.carrierEntity = carrierEntity;
        this.imputation = imputation;
        this.reason = reason;
    }
}
