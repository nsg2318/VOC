package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.adapter.BaseTimeEntity;
import com.voc.voc.domain.Identity;
import com.voc.voc.domain.Penalty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "penalty")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PenaltyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String amount;

    @NotNull
    private Boolean read;

    @NotNull
    private Boolean objection;

    @NotNull
    private String objectionReason;

    public static PenaltyEntity from(Penalty penalty) {

        return new PenaltyEntity(
                IdConverter.convertId(penalty.getPenaltyId()),
                penalty.getAmount(),
                penalty.getRead(),
                penalty.getObjection(),
                penalty.getObjectionReason());
    }

    public Penalty fromThis() {
        return new Penalty(
                new Identity(id),
                amount,
                read,
                objection,
                objectionReason
        );
    }

    public void updateRead() {
        this.read = Boolean.TRUE;
    }

    public void updateObjection() {
        this.objection = Boolean.TRUE;
    }

    public void updateObjection(String objectionReason) {
        this.objectionReason = objectionReason;
    }
}
