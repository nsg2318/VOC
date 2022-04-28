package com.voc.voc.application.port.out;


import com.voc.voc.domain.Carrier;

public interface FindCarrierUsePort {

    Carrier findById(Long id);
}
