package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.CompensationRegistrationDto;
import com.voc.voc.application.port.in.CompensationRegistrationUseCase;
import com.voc.voc.application.port.out.CompensationRegistrationPort;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompensationRegistrationService implements CompensationRegistrationUseCase {

    private final FindVocPort findVocPort;
    private final CompensationRegistrationPort compensationRegistrationPort;

    @Override
    public CompensationRegistrationDto.Response registration(CompensationRegistrationDto.Request request) {
        Voc voc = findVocPort.findById(request.getVocIndex());

        Compensation compensation = Compensation.newInstance(voc, request.getAmount());
        Compensation result = compensationRegistrationPort.persist(compensation);

        return new CompensationRegistrationDto.Response(result);
    }
}
