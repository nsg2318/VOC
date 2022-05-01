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

        Penalty penalty = Penalty.newInstance(request.getAmount());
        Penalty result = penaltyRegistrationPort.persist(penalty);

        //Voc - Penalty Update
        Voc voc = findVocPort.findById(request.getVocIndex());
        vocUpdatePort.updatePenalty(voc, result);

        // App Push (e.g. firebase FCM)
        // ... Logic ...

        return new PenaltyRegistrationDto.Response(result);

    }
}
