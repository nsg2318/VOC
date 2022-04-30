package com.voc.voc.application.port.out;

import com.voc.voc.domain.Voc;

public interface VocRegistrationPort {

    Voc persist(Voc voc);

}
