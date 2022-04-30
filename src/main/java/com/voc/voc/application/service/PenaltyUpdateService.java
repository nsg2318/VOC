package com.voc.voc.application.service;

import com.voc.voc.application.port.in.PenaltyUpdateUseCase;
import com.voc.voc.application.port.out.PenaltyUpdatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PenaltyUpdateService implements PenaltyUpdateUseCase {

    private final PenaltyUpdatePort penaltyUpdatePort;

    @Override
    public void updateRead(Long penaltyIndex) {
        penaltyUpdatePort.updateRead(penaltyIndex);
    }
}
