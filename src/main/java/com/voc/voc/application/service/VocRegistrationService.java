package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.VocRegistrationDto;
import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.application.port.in.VocRegistrationUseCase;
import com.voc.voc.application.port.out.FindCarrierUsePort;
import com.voc.voc.application.port.out.FindSupplierPort;
import com.voc.voc.application.port.out.VocRegistrationPort;
import com.voc.voc.domain.Carrier;
import com.voc.voc.domain.Supplier;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VocRegistrationService implements VocRegistrationUseCase {
    private final FindSupplierPort findSupplierPort;
    private final FindCarrierUsePort findCarrierUsePort;
    private final VocRegistrationPort vocRegistrationPort;


    @Override
    public VocRegistrationDto.Response registration(VocRegistrationDto.Request request) {
        Carrier carrier = findCarrierUsePort.findById(request.getCarrierIndex());
        Supplier supplier = findSupplierPort.findById(request.getSupplierIndex());

        Voc voc = Voc.builder()
                .id(new Voc.VocId(null))
                .vocStatus(VocStatus.OPEN)
                .imputation(request.getImputation())
                .reason(request.getReason())
                .carrier(carrier)
                .supplier(supplier)
                .build();

        VocEntity vocEntity = new VocEntity(voc);
        VocEntity persist = vocRegistrationPort.persist(vocEntity);
        return new VocRegistrationDto.Response(persist);

    }


}
