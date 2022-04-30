package com.voc.voc.application.port.out;

import com.voc.voc.domain.Compensation;

public interface CompensationRegistrationPort {
    Compensation persist(Compensation compensation);
}
