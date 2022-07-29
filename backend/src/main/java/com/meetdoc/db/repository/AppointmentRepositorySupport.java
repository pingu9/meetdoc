package com.meetdoc.db.repository;

import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.QAppointment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class AppointmentRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    QAppointment qAppointment = QAppointment.appointment;

    public List<Appointment> findAppointmentByDoctorIdAndDate(String userId, LocalDateTime date) {
        List<Appointment> list = jpaQueryFactory
                .select(qAppointment)
                .from(qAppointment)
                .where(qAppointment.doctor.userId.eq(userId)
                        .and(qAppointment.appointmentTime
                                .between(date, date.plusDays(1)))
                )
                .fetch();

        return list == null ? Collections.emptyList() : list;
    }
}
