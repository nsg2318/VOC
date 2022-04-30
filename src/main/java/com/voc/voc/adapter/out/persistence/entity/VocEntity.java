package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.adapter.BaseTimeEntity;
import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.domain.Voc;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "voc")
@Getter // Entity Return
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class VocEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VocStatus vocStatus;

    @OneToOne
    @JoinColumn(name = "supplier")
    private SupplierEntity supplierEntity;

    @OneToOne
    @JoinColumn(name = "carrier")
    private CarrierEntity carrierEntity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Imputation imputation;

    @NotNull
    @Size(max = 255)
    private String reason;

    public VocEntity(Voc voc) {
        this.vocStatus = voc.getVocStatus();
        this.supplierEntity = voc.getSupplier().toEntity();
        this.carrierEntity = voc.getCarrier().toEntity();
        this.imputation = voc.getImputation();
        this.reason = voc.getReason();
    }
}
