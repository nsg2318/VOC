package com.voc.voc.application.service;


import com.voc.voc.adapter.in.web.dto.PenaltyRegistrationDto;
import com.voc.voc.application.port.in.PenaltyRegistrationUseCase;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.application.port.out.PenaltyRegistrationPort;
import com.voc.voc.application.port.out.VocUpdatePort;
import com.voc.voc.domain.Penalty;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PenaltyRegistrationService implements PenaltyRegistrationUseCase {

    private final PenaltyRegistrationPort penaltyRegistrationPort;
    private final FindVocPort findVocPort;
    private final VocUpdatePort vocUpdatePort;

    @Override
    public PenaltyRegistrationDto.Response registration(PenaltyRegistrationDto.Request request) {
        Voc voc = findVocPort.findById(request.getVocIndex());

        // TODO: 2022/05/09 기맵핑 VOC 검증

        Penalty penalty = Penalty.newInstance(voc,request.getAmount());
        Penalty result = penaltyRegistrationPort.persist(penalty);

        //Voc - Penalty Update
        vocUpdatePort.updatePenalty(voc, result);

        // App Push (e.g. firebase FCM)
        // ... Logic ...

        return new PenaltyRegistrationDto.Response(result);

    }
}
