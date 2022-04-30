package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.domain.Carrier;
import com.voc.voc.domain.Identity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.voc.voc.adapter.out.persistence.entity.IdConverter.*;

@Entity
@Table(name = "carrier")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarrierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String company;

    public static CarrierEntity from(Carrier carrier) {
        return new CarrierEntity(convertId(carrier.getCarrierId()), carrier.getName(), carrier.getCompany());
    }

    public Carrier fromThis() {
        return new Carrier(
                new Identity(id), name, company);
    }
}
