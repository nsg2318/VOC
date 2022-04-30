package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.domain.Supplier;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supplier")
@Getter
@AllArgsConstructor
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

    public static SupplierEntity from(Supplier supplier){
        return new SupplierEntity(supplier.getSupplierId().getId(), supplier.getVendorName(), supplier.getManagerName(), supplier.getManagerNumber());
    }
    public Supplier fromThis() {
        return new Supplier(
                new Supplier.SupplierId(id), vendorName, managerName, managerNumber);
    }
}
