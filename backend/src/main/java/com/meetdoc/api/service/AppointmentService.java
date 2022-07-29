package com.meetdoc.api.service;

import com.meetdoc.api.request.AppointmentPostReq;
import com.meetdoc.api.request.PrescriptionPatchReq;
import com.meetdoc.api.response.AppointmentGetRes;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.entity.OpeningHours;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public interface AppointmentService {
    List<MedicDepartment> getAllDepartment();
    Appointment createAppointment(AppointmentPostReq appointmentInfo);
    Appointment getAppointmentById(int appointmentId);
    List<Doctor> searchDoctors(int departmentCode, String name, Pageable pageable);
    String getDepartmentNameById(int departmentId);
    List<AppointmentGetRes> getAppointments(String userId);
    List<AppointmentGetRes> getDoctorAppointments(String userId);
    List<Appointment> findAvailableTime(String doctorId, LocalDateTime time);
    void writePrescription(int appointmentId, PrescriptionPatchReq req);

    Appointment findAppointmentByAppointmentId(int appointmentId) throws NoSuchElementException;

    void deleteAppointment(Appointment appointment);

    List<LocalDateTime> getAvailableTimeList(String doctorId, LocalDateTime time, OpeningHours openingHour);
}
