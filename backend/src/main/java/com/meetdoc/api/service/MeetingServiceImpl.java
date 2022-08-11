package com.meetdoc.api.service;

import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    AppointmentRepository appointmentRepository;


    @Override
    public void enterMeetingRoomDoctorLog(Appointment appointment) {
        appointment.setEnterDoctor(LocalDateTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void enterMeetingRoomPatientLog(Appointment appointment) {
        appointment.setEnterPatient(LocalDateTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void leaveMeetingRoomDoctorLog(Appointment appointment) {
        appointment.setLeaveDoctor(LocalDateTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public void leaveMeetingRoomPatientLog(Appointment appointment) {
        appointment.setLeaveDoctor(LocalDateTime.now());
        appointmentRepository.save(appointment);
    }

    @Override
    public boolean isThereDoctorEnterLog(Appointment appointment) {
        if (appointment.getEnterDoctor() != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isTherePatientEnterLog(Appointment appointment) {
        if (appointment.getEnterPatient() != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isDoctorBelongsToMeeting(Appointment appointment, String doctorId) {
        if (appointment.getDoctor().getUserId().equals(doctorId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPatientBelongsToMeeting(Appointment appointment, String patientId) {
        if (appointment.getUser().getUserId().equals(patientId)) {
            return true;
        }
        return false;
    }
}
