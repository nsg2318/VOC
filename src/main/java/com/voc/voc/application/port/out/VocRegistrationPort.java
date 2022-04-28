package com.voc.voc.application.port.out;

import com.voc.voc.adapter.out.persistence.entity.VocEntity;

public interface VocRegistrationPort {

    VocEntity persist(VocEntity vocEntity);

}
