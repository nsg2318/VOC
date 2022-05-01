package com.voc.voc.adapter.out.persistence;

import com.voc.voc.adapter.out.persistence.entity.CompensationEntity;
import com.voc.voc.adapter.out.persistence.entity.VocEntity;
import com.voc.voc.application.port.out.CompensationRegistrationPort;
import com.voc.voc.application.port.out.FindCompensationPort;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompensationAdaptor implements CompensationRegistrationPort, FindCompensationPort {

    private final CompensationRepository compensationRepository;

    @Override
    public Compensation persist(Compensation compensation) {

        CompensationEntity compensationEntity = CompensationEntity.from(compensation);
        CompensationEntity save = compensationRepository.save(compensationEntity);
        return save.fromThisWithoutVoc();
    }

    @Override
    public List<Compensation> findAll() {
        List<CompensationEntity> compensationEntityList = compensationRepository.findAll();
        List<Voc> vocList = compensationEntityList.stream().map(CompensationEntity::getVocEntity).map(VocEntity::fromThis).collect(Collectors.toList());
        List<Compensation> compensationList = compensationEntityList.stream().map(CompensationEntity::fromThis).collect(Collectors.toList());
        for (int i = 0; i < compensationList.size(); i++) {
            compensationList.get(i).addVoc(vocList.get(i));
        }
        return compensationList;
    }
}
