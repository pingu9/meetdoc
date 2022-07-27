package com.meetdoc.api.service;

import com.meetdoc.api.response.AppointmentGetRes;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.MedicDepartment;

import java.util.List;

public interface AppointmentService {
    public List<MedicDepartment> getAllDepartment();
    Appointment getAppointmentById(int appointmentId);
    List<AppointmentGetRes> getAppointments(String userId);
}
