package com.meetdoc.common.util;

import java.time.DateTimeException;
import java.time.DayOfWeek;

public class DayOffWeekMapper {
    public static DayOfWeek of(String dayString) {
        if (dayString.equals("Mon")) {
            return DayOfWeek.MONDAY;
        }
        else if (dayString.equals("Tue")) {
            return DayOfWeek.TUESDAY;
        }
        else if (dayString.equals("Wed")) {
            return DayOfWeek.WEDNESDAY;
        }
        else if (dayString.equals("Thu")) {
            return DayOfWeek.THURSDAY;
        }
        else if (dayString.equals("Fri")) {
            return DayOfWeek.FRIDAY;
        }
        else if (dayString.equals(("Sat"))) {
            return DayOfWeek.SATURDAY;
        }
        else if (dayString.equals("Sun")) {
            return DayOfWeek.SUNDAY;
        }
        else {
            throw new DateTimeException("요일 타입 에러");
        }
    }

    public static String DayOfWeekToString(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(DayOfWeek.MONDAY)) {
            return "Mon";
        }
        else if (dayOfWeek.equals(DayOfWeek.TUESDAY)) {
            return "Tue";
        }
        else if (dayOfWeek.equals(DayOfWeek.WEDNESDAY)) {
            return "Wed";
        }
        else if (dayOfWeek.equals(DayOfWeek.THURSDAY)) {
            return "Thu";
        }
        else if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
            return "Fri";
        }
        else if (dayOfWeek.equals((DayOfWeek.SATURDAY))) {
            return "Sat";
        }
        else if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return "Sun";
        }
        else {
            throw new DateTimeException("요일 타입 에러");
        }
    }
}
