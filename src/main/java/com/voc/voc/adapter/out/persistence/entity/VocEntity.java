package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.adapter.BaseTimeEntity;
import com.voc.voc.adapter.out.persistence.status.Imputation;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.domain.Identity;
import com.voc.voc.domain.Voc;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @OneToOne
    @JoinColumn(name = "compensation")
    private CompensationEntity compensationEntity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Imputation imputation;

    @NotNull
    @Size(max = 255)
    private String reason;

    @NotNull
    private Boolean claim;

    public static VocEntity from(Voc voc) {
        return new VocEntity(voc.getVocId().getNumber(), voc.getVocStatus(),
                SupplierEntity.from(voc.getSupplier()),
                CarrierEntity.from(voc.getCarrier()),
                null,
                voc.getImputation(),
                voc.getReason(),
                voc.getClaim());
    }

    public Voc fromThis() {
        return new Voc(
                new Identity(id),
                vocStatus,
                supplierEntity.fromThis(),
                carrierEntity.fromThis(),
                null,
                imputation,
                reason,
                claim);

    }
}
