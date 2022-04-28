package com.voc.voc.adapter.out.persistence;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "penalty")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PenaltyEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long amount;


}
