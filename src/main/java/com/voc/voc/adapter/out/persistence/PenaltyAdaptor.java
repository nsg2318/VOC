package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.PenaltyEntity;
import com.voc.voc.application.port.out.PenaltyRegistrationPort;
import com.voc.voc.domain.Penalty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class PenaltyAdaptor implements PenaltyRegistrationPort {

    private final PenaltyRepository penaltyRepository;
    @Override
    public Penalty persist(Penalty penalty) {
        PenaltyEntity save = penaltyRepository.save(PenaltyEntity.from(penalty));
        return save.fromThis();
    }
}
