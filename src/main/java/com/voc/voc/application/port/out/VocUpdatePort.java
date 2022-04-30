package com.voc.voc.application.port.out;

import com.voc.voc.adapter.out.persistence.status.VocStatus;
import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Voc;

public interface VocUpdatePort {
    void updateCompensation(Voc voc, Compensation compensation);

    void updateStatus(Voc voc, VocStatus vocStatus);
}
