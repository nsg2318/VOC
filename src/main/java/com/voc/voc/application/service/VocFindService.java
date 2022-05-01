package com.voc.voc.application.service;

import com.voc.voc.adapter.in.web.dto.VocGetAllDto;
import com.voc.voc.application.port.in.VocGetAllUseCase;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocFindService implements VocGetAllUseCase {

    private final FindVocPort findVocPort;

    @Override
    public VocGetAllDto.Response getAll() {
        List<Voc> vocList = findVocPort.findAll();
        return new VocGetAllDto.Response(vocList);
    }
}
