package com.github.lramosduarte.fake.generator;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


public class DateTimeGenerator implements Generator<LocalDateTime>{
    private final int ATE_100_DIAS_SEGUNSO = (24 * 60 * 60) * 100 ;

    @Override
    public LocalDateTime generate(int ignored) {
        ZonedDateTime today = ZonedDateTime.now(ZoneOffset.UTC);
        return today.plusSeconds(new NumberGenerator().generate(this.ATE_100_DIAS_SEGUNSO)).toLocalDateTime();
    }
}
