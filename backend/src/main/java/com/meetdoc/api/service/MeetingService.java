package com.meetdoc.api.service;

import com.meetdoc.db.entity.Appointment;

public interface MeetingService {
    void enterMeetingRoomDoctorLog(Appointment appointment);
    void enterMeetingRoomPatientLog(Appointment appointment);
    void leaveMeetingRoomDoctorLog(Appointment appointment);
    void leaveMeetingRoomPatientLog(Appointment appointment);

    boolean isThereDoctorEnterLog(Appointment appointment);
    boolean isTherePatientEnterLog(Appointment appointment);
    boolean isDoctorBelongsToMeeting(Appointment appointment, String doctorId);
    boolean isPatientBelongsToMeeting(Appointment appointment, String patientId);
}
