package com.voc.voc.adapter.out.persistence.entity;


import com.voc.voc.domain.Identity;
import com.voc.voc.domain.Supplier;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.voc.voc.adapter.out.persistence.entity.IdConverter.*;

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

    public static SupplierEntity from(Supplier supplier) {
        return new SupplierEntity(convertId(supplier.getSupplierId()), supplier.getVendorName(), supplier.getManagerName(), supplier.getManagerNumber());
    }

    public Supplier fromThis() {
        return new Supplier(
                new Identity(id), vendorName, managerName, managerNumber);
    }
}
