package com.voc.voc.adapter.out.persistence.entity;

import com.voc.voc.adapter.BaseTimeEntity;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Identity;
import com.voc.voc.domain.Voc;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.voc.voc.adapter.out.persistence.entity.IdConverter.convertId;

@Entity
@Table(name = "compensation")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompensationEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "compensationEntity")
    private VocEntity vocEntity;

    @NotNull
    String amount;

    public CompensationEntity(Long id, String amount) {
        this.id = id;
        this.amount = amount;
    }

    public static CompensationEntity from(Compensation compensation) {
        return new CompensationEntity(convertId(compensation.getCompensationId()), compensation.getAmount());
    }

    public Compensation fromThis() {
        return new Compensation(new Identity(id),amount);
    }

    public Compensation fromThisWithoutVoc(){
        return new Compensation(new Identity(id), amount, null);
    }

}
