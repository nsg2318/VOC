package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.application.port.out.FindVocPort;
import com.voc.voc.application.port.out.VocRegistrationPort;
import com.voc.voc.application.port.out.VocUpdatePort;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Penalty;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Transactional
public class VocAdaptor implements VocRegistrationPort, FindVocPort, VocUpdatePort {

    private final VocRepository vocRepository;

    @Override
    public Voc persist(Voc voc) {
        VocEntity save = vocRepository.save(VocEntity.fromWithoutCompensation(voc));
        return save.fromThisWithoutCompensation();
    }

    @Override
    public Voc findById(Long id) {
        VocEntity vocEntity = vocRepository.findById(id)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        return vocEntity.getCompensationEntity() == null ? vocEntity.fromThisWithoutCompensation() : vocEntity.fromThisWithCompensation();
    }

    @Override
    public Voc findByPenaltyId(Long id) {
        VocEntity vocEntity = vocRepository.findByPenaltyEntityId(id)
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        return vocEntity.fromThisWithCompensation();
    }

    @Override
    public void updateCompensation(Voc voc, Compensation compensation) {
        VocEntity vocEntity = vocRepository.findById(voc.getVocId().getNumber())
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        vocEntity.updateCompensation(compensation);
    }

    @Override
    public void updatePenalty(Voc voc, Penalty penalty) {
        VocEntity vocEntity = vocRepository.findById(voc.getVocId().getNumber())
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        vocEntity.updatePenalty(penalty);
    }

    @Override
    public void updateStatus(Voc voc, VocStatus vocStatus) {
        VocEntity vocEntity = vocRepository.findById(voc.getVocId().getNumber())
                .orElseThrow(() -> new InvalidParameterException("Invalid Index"));
        vocEntity.updateStatus(vocStatus);
    }

    @Override
    public List<Voc> findAll() {
        List<VocEntity> vocEntityList = vocRepository.findAll();
        return vocEntityList.stream().map(VocEntity::fromThis).collect(Collectors.toList());
    }
}
