package com.temario.m8others;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public enum FormatDate {
    SHORT(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)),
    MEDIUM(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
    FULL(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    
    private final DateTimeFormatter dt;

    private FormatDate(DateTimeFormatter dt) {
        this.dt = dt;
    }

    public DateTimeFormatter getDt() {
        return dt;
    }
    
}
