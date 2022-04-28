package com.voc.voc.adapter.out.persistence;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carrier")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarrierEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String company;

}
