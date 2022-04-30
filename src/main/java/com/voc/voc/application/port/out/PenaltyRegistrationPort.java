package com.voc.voc.application.port.out;

import com.voc.voc.domain.Penalty;

public interface PenaltyRegistrationPort {
    Penalty persist(Penalty penalty);
}
