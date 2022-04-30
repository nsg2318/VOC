package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.application.port.out.VocRegistrationPort;
import com.voc.voc.application.port.out.VocUpdatePort;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;

@Component
@RequiredArgsConstructor
@Transactional
public class VocAdaptor implements VocRegistrationPort, FindVocPort, VocUpdatePort {

    private final VocRepository vocRepository;

    @Override
    public Voc persist(Voc voc) {
        VocEntity save = vocRepository.save(VocEntity.from(voc));
        return save.fromThis();
    }

    @Override
    public Voc findById(Long id) {
        VocEntity vocEntity = vocRepository.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        return vocEntity.fromThis();
    }

    @Override
    public Voc updateCompensation(Voc voc, Compensation compensation) {
        VocEntity vocEntity = vocRepository.findById(voc.getVocId().getNumber())
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        VocEntity save = vocEntity.updateCompensation(compensation);
        return save.fromThisWithCompensation();
    }
}
