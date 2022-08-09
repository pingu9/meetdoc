package com.meetdoc.common.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateConverter {
    public static LocalTime toLocalTime(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        if (calendar.get(Calendar.AM_PM) == Calendar.PM) {
            hour += 12;
        }

        return LocalTime.of(hour, minute);
    }

    public static Date toDate(LocalDateTime dateTime) {
        return Timestamp.valueOf(dateTime);
    }

    public static LocalDateTime dateStringToLocalDateTime(String dateString) {
        return LocalDateTime.of(dateStringToLocalDate(dateString), LocalTime.of(0, 0));
    }

    public static LocalDate dateStringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }

    public static LocalDateTime findNextTimeSlot() {
        LocalDateTime now = LocalDateTime.now();
        int minutes = now.getMinute();
        int minutesOffset;
        if (minutes > 30) {
            minutesOffset = 60 - minutes;
        }
        else {
            minutesOffset = 30 - minutes;
        }
        return now.withSecond(0).withNano(0).plusMinutes(minutesOffset);
    }

    public static LocalDateTime findBeforeTimeSlot() {
        LocalDateTime now = LocalDateTime.now();
        int minutes = now.getMinute();
        int minutesOffset;
        if (minutes > 30) {
            minutesOffset = minutes - 30;
        }
        else {
            minutesOffset = minutes;
        }
        return now.withSecond(0).withNano(0).minusMinutes(minutesOffset);
    }
}
