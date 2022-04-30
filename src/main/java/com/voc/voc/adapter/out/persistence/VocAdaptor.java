package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.application.port.out.VocRegistrationPort;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class VocAdaptor implements VocRegistrationPort {

    private final VocRepository vocRepository;

    @Override
    public Voc persist(Voc voc) {
        VocEntity save = vocRepository.save(VocEntity.from(voc));
        return save.fromThis();
    }
}
