package com.voc.voc.application.port.out;

import com.voc.voc.domain.Voc;

import java.util.List;

public interface FindVocPort {

    Voc findById(Long id);

    Voc findByPenaltyId(Long id);

    List<Voc> findAll();
}
