package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.PenaltyEntity;
import com.voc.voc.application.port.out.FindPenaltyPort;
import com.voc.voc.application.port.out.PenaltyRegistrationPort;
import com.voc.voc.application.port.out.PenaltyUpdatePort;
import com.voc.voc.domain.Penalty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;

@Component
@RequiredArgsConstructor
@Transactional
public class PenaltyAdaptor implements PenaltyRegistrationPort, FindPenaltyPort, PenaltyUpdatePort {

    private final PenaltyRepository penaltyRepository;
    @Override
    public Penalty persist(Penalty penalty) {
        PenaltyEntity save = penaltyRepository.save(PenaltyEntity.from(penalty));
        return save.fromThis();
    }

    @Override
    public Penalty findById(Long id) {
        PenaltyEntity penaltyEntity = penaltyRepository.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        return penaltyEntity.fromThis();
    }

    @Override
    public void updateRead(Long penaltyIndex) {
        PenaltyEntity penaltyEntity = penaltyRepository.findById(penaltyIndex)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        penaltyEntity.updateRead();
    }

    @Override
    public void updateObjection(Long penaltyIndex) {
        PenaltyEntity penaltyEntity = penaltyRepository.findById(penaltyIndex)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        penaltyEntity.updateObjection();
    }
}
