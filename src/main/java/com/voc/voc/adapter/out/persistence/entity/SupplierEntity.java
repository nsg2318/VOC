package com.voc.voc.adapter.out.persistence.entity;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supplier")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String vendorName;

    @NotNull
    private String managerName;

    @NotNull
    private String managerNumber;

    @Builder
    public SupplierEntity(Long id,String vendorName, String managerName, String managerNumber) {
        this.id = id;
        this.vendorName = vendorName;
        this.managerName = managerName;
        this.managerNumber = managerNumber;
    }
}
