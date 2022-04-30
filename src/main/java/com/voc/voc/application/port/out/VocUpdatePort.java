package com.voc.voc.application.port.out;

import com.voc.voc.domain.Compensation;
import com.voc.voc.domain.Voc;

public interface VocUpdatePort {
    Voc updateCompensation(Voc voc, Compensation compensation);
}
