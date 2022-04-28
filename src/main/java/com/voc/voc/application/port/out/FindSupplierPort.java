package com.voc.voc.application.port.out;

import com.voc.voc.domain.Supplier;

public interface FindSupplierPort {

    Supplier findById(Long id);
}
