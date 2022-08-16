package com.meetdoc.common.util;

import com.meetdoc.db.entity.OpeningHours;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class ReadOnlyTimeStore implements TimeStore{
    private Map<LocalDateTime, Boolean> timeStore = new LinkedHashMap<>();
    private OpeningHours openingHour;
    private LocalDate today;
    private LocalTime open;
    private LocalTime close;
    private LocalTime lunchStart;
    private LocalTime lunchEnd;

    public ReadOnlyTimeStore(OpeningHours openingHour, LocalDate date) {
        this.openingHour = openingHour;
        this.today = date;
        setHourInfo();
        init();
    }

    private void init() {
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

    private Boolean isAvailable(LocalDateTime time) {
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

    @Override
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
}
