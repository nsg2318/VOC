package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.adapter.BaseTimeEntity;
import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Identity;
import com.voc.voc.domain.Penalty;
import com.voc.voc.domain.Voc;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.voc.voc.adapter.out.persistence.entity.IdConverter.convertId;

@Entity
@Table(name = "voc")
@Getter
@AllArgsConstructor
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

    @OneToOne(mappedBy = "vocEntity")
    private CompensationEntity compensationEntity;

    @OneToOne(mappedBy = "vocEntity")
    private PenaltyEntity penaltyEntity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Imputation imputation;

    @NotNull
    @Size(max = 255)
    private String reason;

    @NotNull
    private Boolean claim;

    public static VocEntity fromWithoutCompensation(Voc voc) {
        return new VocEntity(convertId(voc.getVocId()), voc.getVocStatus(),
            SupplierEntity.from(voc.getSupplier()),
            CarrierEntity.from(voc.getCarrier()),
            null, null,
            voc.getImputation(),
            voc.getReason(),
            voc.getClaim());
    }

    public VocEntity(Long id, VocStatus vocStatus, SupplierEntity supplierEntity, CarrierEntity carrierEntity, Imputation imputation, String reason, Boolean claim) {
        this.id = id;
        this.vocStatus = vocStatus;
        this.supplierEntity = supplierEntity;
        this.carrierEntity = carrierEntity;
        this.penaltyEntity = penaltyEntity;
        this.imputation = imputation;
        this.reason = reason;
        this.claim = claim;
    }

    public static VocEntity fromWithCompensation(Voc voc) {
        return new VocEntity(convertId(voc.getVocId()), voc.getVocStatus(),
            SupplierEntity.from(voc.getSupplier()),
            CarrierEntity.from(voc.getCarrier()),
            voc.getImputation(),
            voc.getReason(),
            voc.getClaim());
    }

    public void updateCompensation(Compensation compensation) {
        this.compensationEntity = CompensationEntity.from(compensation);
    }

    public void updatePenalty(Penalty penalty) {
        this.penaltyEntity = PenaltyEntity.from(penalty);
    }

    public Voc fromThis() {
        return new Voc(
            new Identity(id),
            vocStatus,
            supplierEntity.fromThis(),
            carrierEntity.fromThis(),
            imputation,
            reason,
            claim);
    }

    public Voc fromThisWithoutCompensation() {
        return new Voc(
            new Identity(id),
            vocStatus,
            supplierEntity.fromThis(),
            carrierEntity.fromThis(),
            imputation,
            reason,
            claim);
    }

    public void updateStatus(VocStatus vocStatus) {
        this.vocStatus = vocStatus;
    }
}
