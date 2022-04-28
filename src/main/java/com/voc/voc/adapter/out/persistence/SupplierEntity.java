package com.voc.voc.adapter.out.persistence;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supplier")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SupplierEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String vendorName;

    @NotNull
    private String managerName;

    @NotNull
    private String managerNumber;


}
