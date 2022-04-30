package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.CompensationEntity;
import com.voc.voc.application.port.out.CompensationRegistrationPort;
import com.voc.voc.domain.Compensation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompensationAdaptor implements CompensationRegistrationPort {

    private final CompensationRepository compensationRepository;

    @Override
    public Compensation persist(Compensation compensation) {

        CompensationEntity compensationEntity = CompensationEntity.from(compensation);
        CompensationEntity save = compensationRepository.save(compensationEntity);
        return save.fromThis();
    }
}
