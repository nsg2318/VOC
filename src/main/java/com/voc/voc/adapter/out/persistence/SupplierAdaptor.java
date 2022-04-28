package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.SupplierEntity;
import com.voc.voc.application.port.out.FindSupplierPort;
import com.voc.voc.domain.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class SupplierAdaptor implements FindSupplierPort {

    private final SupplierRepository supplierRepository;

    @Override
    public Supplier findById(Long id) {

        SupplierEntity supplierEntity = supplierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can not find data"));
        return new Supplier(supplierEntity);
    }
}
