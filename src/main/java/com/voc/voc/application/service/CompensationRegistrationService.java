package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.CompensationRegistrationDto;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.application.port.in.CompensationRegistrationUseCase;
import com.voc.voc.application.port.out.CompensationRegistrationPort;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.application.port.out.VocUpdatePort;
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
    private final VocUpdatePort vocUpdatePort;

    @Override
    public CompensationRegistrationDto.Response registration(CompensationRegistrationDto.Request request) {
        Voc voc = findVocPort.findById(request.getVocIndex());

        // TODO: 2022/05/09 기맵핑 VOC 검증

        Compensation compensation = Compensation.newInstance(request.getAmount(),voc);
        Compensation result = compensationRegistrationPort.persist(compensation);

        //Voc 내 Compensation 정보 업데이트
        vocUpdatePort.updateCompensation(voc, result);
        vocUpdatePort.updateStatus(voc, VocStatus.OPEN);


        return new CompensationRegistrationDto.Response(result);
    }
}
