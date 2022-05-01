package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.PenaltyObjectionDto;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.application.port.in.PenaltyUpdateUseCase;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.application.port.out.PenaltyUpdatePort;
import com.voc.voc.application.port.out.VocUpdatePort;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PenaltyUpdateService implements PenaltyUpdateUseCase {
    private final PenaltyUpdatePort penaltyUpdatePort;

    private final FindVocPort findVocPort;
    private final VocUpdatePort vocUpdatePort;

    @Override
    public void updateRead(Long penaltyIndex) {
        penaltyUpdatePort.updateRead(penaltyIndex);
    }

    //운송기사 인정
    @Override
    public void updateObjection(Long penaltyIndex) {
        penaltyUpdatePort.updateObjection(penaltyIndex);

        Voc voc = findVocPort.findByPenaltyId(penaltyIndex);
        vocUpdatePort.updateStatus(voc, VocStatus.CLOSED);
    }

    //운송기사 이의제기
    @Override
    public void updateObjection(Long penaltyIndex, PenaltyObjectionDto.Request request) {
        penaltyUpdatePort.updateObjection(penaltyIndex, request.getObjectionReason());

        Voc voc = findVocPort.findByPenaltyId(penaltyIndex);
        vocUpdatePort.updateStatus(voc, VocStatus.OBJECTION);
    }
}
