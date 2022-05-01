package com.voc.voc.application.port.out;

import com.voc.voc.domain.Voc;

public interface FindVocPort {

    Voc findById(Long id);

    Voc findByPenaltyId(Long id);
}
