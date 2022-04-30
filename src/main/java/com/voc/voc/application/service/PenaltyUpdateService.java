package com.voc.voc.application.service;

import com.voc.voc.application.port.in.PenaltyUpdateUseCase;
import com.voc.voc.application.port.out.FindPenaltyPort;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.application.port.out.PenaltyUpdatePort;
import com.voc.voc.application.port.out.VocUpdatePort;
import com.voc.voc.domain.Penalty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PenaltyUpdateService implements PenaltyUpdateUseCase {
    private final PenaltyUpdatePort penaltyUpdatePort;
    private final FindPenaltyPort findPenaltyPort;
    private final VocUpdatePort vocUpdatePort;

    @Override
    public void updateRead(Long penaltyIndex) {
        penaltyUpdatePort.updateRead(penaltyIndex);
    }

    @Override
    public void updateObjection(Long penaltyIndex) {
        Penalty penalty = findPenaltyPort.findById(penaltyIndex);
        penaltyUpdatePort.updateObjection(penaltyIndex);
        vocUpdatePort.updateStatus(penalty.getVoc());
    }
}
