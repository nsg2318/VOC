package com.voc.voc.application.port.out;


import com.voc.voc.domain.Carrier;

public interface FindCarrierPort {

    Carrier findById(Long id);
}
