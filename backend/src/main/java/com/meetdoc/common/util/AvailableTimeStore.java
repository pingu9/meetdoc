package com.meetdoc.common.util;

import com.meetdoc.db.entity.DayOff;
import com.meetdoc.db.entity.OpeningHours;
import com.meetdoc.db.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

public class AvailableTimeStore {
    private Map<LocalDateTime, Boolean> timeStore = new LinkedHashMap<>();
    private int timeUnit = 30; // 30분 단위로 시간 관리
    private int totalTimeUnit = 48; // 30분 단위일 경우 하루는 48개의 time unit으로 나뉜다.

    private OpeningHours openingHour;
    private LocalDate today;
    private LocalTime open;
    private LocalTime close;
    private LocalTime lunchStart;
    private LocalTime lunchEnd;

    public AvailableTimeStore(OpeningHours openingHour, LocalDate date) {
        this.openingHour = openingHour;
        this.today = date;
        setHourInfo();
        init();
    }

    public void init() {
        LocalDateTime base = LocalDateTime.of(today, LocalTime.of(0, 0));
        for (long i = 0; i < totalTimeUnit; i++) {
            LocalDateTime nextTime = base.plusMinutes((i * timeUnit));
            if (isAvailable(nextTime)) {
                timeStore.put(nextTime, true);
            }
        }
    }


    private void setHourInfo() {
        open = DateConverter.toLocalTime(openingHour.getOpen());
        close = DateConverter.toLocalTime(openingHour.getClose());
        lunchStart = DateConverter.toLocalTime(openingHour.getLunchHour());
        lunchEnd = lunchStart.plusHours(1);
    }

    public Boolean isAvailable(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now().plusSeconds(1);
        if (time.isBefore(now)) {
            return false;
        }

        LocalTime localTime = time.toLocalTime();
        if (localTime.isBefore(open)) {
            return false;
        }
        if (localTime.compareTo(close) >= 0) {
            return false;
        }
        if (localTime.compareTo(lunchStart) >= 0 && localTime.isBefore(lunchEnd)) {
            return false;
        }

        return true;
    }


    public void book(LocalDateTime time) {
        timeStore.put(time, false);
    }

    public List<LocalDateTime> getAvailableTimeList() {
        List<LocalDateTime> list = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Boolean> entry : timeStore.entrySet()) {
            Boolean isAvailable = entry.getValue();
            if (isAvailable) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public void setTimeUnit(int timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void setTotalTimeUnit(int totalTimeUnit) {
        this.totalTimeUnit = totalTimeUnit;
    }
}
