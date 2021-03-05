package com.github.lramosduarte.fake.setter;

import com.github.lramosduarte.analyser.AnalyserGenerics;
import com.github.lramosduarte.data.Attribute;
import com.github.lramosduarte.fake.FakeDataGenerator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


public class DateTimeSetter implements Setter, AnalyserGenerics {

    private final FakeDataGenerator fakeDataGenerator;

    public DateTimeSetter(FakeDataGenerator fakeDataGenerator) {
        this.fakeDataGenerator = fakeDataGenerator;
    }

    @Override
    public <Instance> void setAttribute(Attribute attribute, Instance object) throws IllegalAccessException {
        attribute.field.setAccessible(true);
        LocalDateTime value = this.fakeDataGenerator.make(attribute);
        if (attribute.field.getType().isAssignableFrom(LocalDate.class)) {
            attribute.field.set(object, value.toLocalDate());
        } else if (attribute.field.getType().isAssignableFrom(LocalDateTime.class)) {
            attribute.field.set(object, value);
        } else if (attribute.field.getType().isAssignableFrom(LocalTime.class)) {
            attribute.field.set(object, value.toLocalTime());
        } else if (attribute.field.getType().isAssignableFrom(ZonedDateTime.class)) {
            attribute.field.set(object, value.atZone(ZoneOffset.UTC));
        } else if (attribute.field.getType().isAssignableFrom(Month.class)) {
            attribute.field.set(object, value.getMonth());
        } else {
            attribute.field.set(object, value.getDayOfWeek());
        }
    }

}
