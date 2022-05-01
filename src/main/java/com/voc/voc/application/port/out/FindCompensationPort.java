package com.voc.voc.application.port.out;

import com.voc.voc.domain.Compensation;

import java.util.List;

public interface FindCompensationPort {

    List<Compensation> findAll();
}
