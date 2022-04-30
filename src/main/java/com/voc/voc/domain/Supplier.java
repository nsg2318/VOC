package com.voc.voc.domain;


import com.voc.voc.adapter.out.persistence.entity.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * 고객사 도메인
 */
@Value
@Getter
@AllArgsConstructor
public class Supplier {

    Identity supplierId;
    String vendorName;
    String managerName;
    String managerNumber;


    public Supplier(SupplierEntity supplierEntity) {
        this.supplierId = new Identity(supplierEntity.getId());
        this.vendorName = supplierEntity.getVendorName();
        this.managerName = supplierEntity.getManagerName();
        this.managerNumber = supplierEntity.getManagerNumber();
    }

}
