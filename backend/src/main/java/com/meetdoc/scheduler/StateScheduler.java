package com.meetdoc.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StateScheduler {
    @Scheduled(cron = "0 55,05 * * * ?")
    public void openScheduler() {

        // 다음 타임슬롯이 예약 시간이고 STATUS가 WAITING인 예약들을 모두 찾는다.
        // 이 예약들의 STATUS를 모두 OPEN으로 바꾼다.
    }

    @Scheduled(cron = "0 0,30 * * * ?")
    public void finishScheduler() {

        //이전 타임슬롯이 예약시간이고 STATUS가 OPEN인 예약들을 모두 찾는다.
        //이 예약들의 STATUS를 모두 PENDING_PRESCRIPTION으로 바꾼다.

    }
}
