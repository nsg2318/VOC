package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.application.port.out.VocRegistrationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
public class VocAdaptor implements VocRegistrationPort {

    private final VocRepository vocRepository;

    @Override
    public VocEntity persist(VocEntity vocEntity) {
        VocEntity save = vocRepository.save(vocEntity);
        int a =1;
        return save;
    }
}
