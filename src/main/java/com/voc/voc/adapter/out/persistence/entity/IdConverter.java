package com.voc.voc.adapter.out.persistence.entity;

import com.voc.voc.domain.Identity;

/**
 * NPE 방지용 컨버터
 */
public class IdConverter {
    public static Long convertId(Identity identity) {
        if (identity != null && identity.getNumber() != Long.MIN_VALUE) {
            return identity.getNumber();
        }

        return null;
    }
}
