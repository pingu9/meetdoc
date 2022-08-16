package com.meetdoc.common.util;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeStore {
    int timeUnit = 30; // 30분 단위로 시간 관리
    int totalTimeUnit = 48; // 30분 단위일 경우 하루는 48개의 time unit으로 나뉜다.

    public List<LocalDateTime> getAvailableTimeList();
}
