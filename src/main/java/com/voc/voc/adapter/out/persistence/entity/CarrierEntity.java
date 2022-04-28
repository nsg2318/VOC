package com.voc.voc.adapter.out.persistence.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carrier")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarrierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String company;

    @Builder
    public CarrierEntity(Long id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }
}
