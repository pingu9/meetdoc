package com.meetdoc.common.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Component
public class AvailableTimeStore {
    private Map<LocalDateTime, Boolean> timeStore = new LinkedHashMap<>();
    private int timeUnit = 30; // 30분 단위로 시간 관리
    private int totalTimeUnit = 48; // 30분 단위일 경우 하루는 48개의 time unit으로 나뉜다.

    public void init(LocalDate date) {
        LocalDateTime base = LocalDateTime.of(date, LocalTime.of(0, 0));
        for (int i = 0; i < totalTimeUnit; i++) {
            timeStore.put(base.plusMinutes(i * timeUnit), true);
        }
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
