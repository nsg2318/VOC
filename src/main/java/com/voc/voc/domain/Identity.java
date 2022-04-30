package com.voc.voc.domain;

import lombok.Value;

@Value
public class Identity {
    Long number;
    public static Identity nothing() {
        return new Identity(Long.MIN_VALUE);
    }
}
