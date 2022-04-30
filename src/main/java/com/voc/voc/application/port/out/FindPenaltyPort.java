package com.voc.voc.application.port.out;

import com.voc.voc.domain.Penalty;

public interface FindPenaltyPort {
    Penalty findById(Long id);
}
