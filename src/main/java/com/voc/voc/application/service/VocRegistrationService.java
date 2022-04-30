package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.VocRegistrationDto;
import com.voc.voc.adapter.out.persistence.entity.CarrierEntity;
import com.voc.voc.adapter.out.persistence.entity.CompensationEntity;
import com.voc.voc.adapter.out.persistence.entity.SupplierEntity;
import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.application.port.in.VocRegistrationUseCase;
import com.voc.voc.application.port.out.FindCarrierUsePort;
import com.voc.voc.application.port.out.FindSupplierPort;
import com.voc.voc.application.port.out.VocRegistrationPort;
import com.voc.voc.domain.Carrier;
import com.voc.voc.domain.Supplier;
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

        VocEntity vocEntity = new VocEntity(null,VocStatus.OPEN, SupplierEntity.from(supplier), CarrierEntity.from(carrier), null, request.getImputation(), request.getReason(), request.getClaim());
        VocEntity persist = vocRegistrationPort.persist(vocEntity);
        return new VocRegistrationDto.Response(persist);

    }


}
