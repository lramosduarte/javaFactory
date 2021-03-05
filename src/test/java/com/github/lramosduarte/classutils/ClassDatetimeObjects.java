package com.github.lramosduarte.classutils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.DayOfWeek;


import lombok.Data;


@Data
public class ClassDatetimeObjects {
    private LocalDate atrLocalDate;
    private LocalDateTime atrLocalDateTime;
    private LocalTime atrLocalTime;
    private ZonedDateTime atrZonedDateTime;
    private Month atrMonth;
    private DayOfWeek atrDayOfWeek;
}
