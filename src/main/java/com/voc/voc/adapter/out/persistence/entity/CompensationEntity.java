package com.voc.voc.adapter.out.persistence.entity;

import com.voc.voc.adapter.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compensation")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompensationEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "voc")
    private VocEntity vocEntity;

    @NotNull
    String amount;

}
