package com.meetdoc.api.service;

import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.MedicDepartment;

import java.util.List;

public interface AppointmentService {
    public List<MedicDepartment> getAllDepartment();
    Appointment getAppointmentById(int appointmentId);
}
