package com.voc.voc.adapter.out.persistence.entity;

import com.voc.voc.domain.Identity;

public class IdConverter {
    public static Long convertId(Identity identity) {
        if (identity != null && identity.getNumber() != Long.MIN_VALUE) {
            return identity.getNumber();
        }

        return null;
    }
}
