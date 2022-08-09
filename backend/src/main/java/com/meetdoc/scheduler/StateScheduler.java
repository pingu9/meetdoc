package com.meetdoc.scheduler;

import com.meetdoc.common.util.DateConverter;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.repository.AppointmentRepository;
import com.meetdoc.db.repository.AppointmentRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class StateScheduler {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AppointmentRepositorySupport appointmentRepositorySupport;


    @Scheduled(cron = "0 55,25 * * * ?")
    public void openScheduler() {

        // 다음 타임슬롯이 예약 시간이고 STATUS가 WAITING인 예약들을 모두 찾는다.
        // 이 예약들의 STATUS를 모두 OPEN으로 바꾼다.

        LocalDateTime nextTimeSlot = DateConverter.findNextTimeSlot();
        List<Appointment> appointments = appointmentRepositorySupport.findAppointmentsByTimeAndStatus(nextTimeSlot, "WAITING");
        for (Appointment appointment: appointments) {
            appointment.setStatus("OPEN");
        }
        appointmentRepository.saveAll(appointments);
    }

    @Scheduled(cron = "0 0,30 * * * ?")
    public void finishScheduler() {

        //이전 타임슬롯이 예약시간이고 STATUS가 OPEN인 예약들을 모두 찾는다.
        //이 예약들의 STATUS를 모두 PENDING_PRESCRIPTION으로 바꾼다.
        //처방전이 입력되었을 때 FINISHED로 바꾸도록 한다.

        LocalDateTime beforeTimeSlot = DateConverter.findBeforeTimeSlot();
        List<Appointment> appointments = appointmentRepositorySupport.findAppointmentsByTimeAndStatus(beforeTimeSlot, "OPEN");
        for (Appointment appointment: appointments) {
            appointment.setStatus("PENDING_PRESCRIPTION");
        }
        appointmentRepository.saveAll(appointments);
    }
}
