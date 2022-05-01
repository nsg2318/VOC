package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.CompensationGetAllDto;
import com.voc.voc.application.port.in.CompensationGetAllUseCase;
import com.voc.voc.application.port.out.FindCompensationPort;
import com.voc.voc.domain.Compensation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompensationFindService implements CompensationGetAllUseCase {

    private final FindCompensationPort findCompensationPort;

    @Override
    public CompensationGetAllDto.Response getAllCompensation() {

        List<Compensation> compensationList = findCompensationPort.findAll();
        return new CompensationGetAllDto.Response(compensationList);

    }
}
