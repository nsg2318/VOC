package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.CarrierEntity;
import com.voc.voc.application.port.out.FindCarrierPort;
import com.voc.voc.domain.Carrier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
@RequiredArgsConstructor
public class CarrierAdaptor implements FindCarrierPort {

    private final CarrierRepository carrierRepository;

    @Override
    public Carrier findById(Long id) {

        CarrierEntity carrierEntity = carrierRepository.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        return new Carrier(carrierEntity);

    }
}
