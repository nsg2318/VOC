package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.VocRegistrationDto;
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

        Voc voc = Voc.newInstance(supplier, carrier, request.getImputation(), request.getReason(), request.getClaim());
        Voc result = vocRegistrationPort.persist(voc);
        return new VocRegistrationDto.Response(result);

    }


}
