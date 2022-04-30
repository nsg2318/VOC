package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.PenaltyObjectionDto;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.application.port.in.PenaltyUpdateUseCase;
import com.voc.voc.application.port.out.FindPenaltyPort;
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

    //운송기사 인정
    @Override
    public void updateObjection(Long penaltyIndex) {
        Penalty penalty = findPenaltyPort.findById(penaltyIndex);
        penaltyUpdatePort.updateObjection(penaltyIndex);
        vocUpdatePort.updateStatus(penalty.getVoc(), VocStatus.CLOSED);
    }

    //운송기사 이의제기
    @Override
    public void updateObjection(Long penaltyIndex, PenaltyObjectionDto.Request request) {
        Penalty penalty = findPenaltyPort.findById(penaltyIndex);
        penaltyUpdatePort.updateObjection(penaltyIndex, request.getObjectionReason());
        vocUpdatePort.updateStatus(penalty.getVoc(),VocStatus.OBJECTION);
    }
}
