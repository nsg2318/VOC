package com.voc.voc.adapter.out.persistence.entity;

import com.voc.voc.adapter.BaseTimeEntity;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Identity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.voc.voc.adapter.out.persistence.entity.IdConverter.*;

@Entity
@Table(name = "compensation")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CompensationEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "voc")
    private VocEntity vocEntity;

    @NotNull
    String amount;

    public static CompensationEntity from(Compensation compensation) {
        return new CompensationEntity(convertId(compensation.getCompensationId()), VocEntity.fromWithoutCompensation(compensation.getVoc()), compensation.getAmount());
    }

    public Compensation fromThis() {
        return new Compensation(new Identity(id), vocEntity.fromThisWithoutCompensation(), amount);
    }

}
