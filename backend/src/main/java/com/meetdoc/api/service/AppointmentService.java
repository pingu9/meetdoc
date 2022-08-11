package com.meetdoc.api.service;

import com.meetdoc.api.request.AppointmentPostReq;
import com.meetdoc.api.request.PrescriptionPatchReq;
import com.meetdoc.api.response.AppointmentGetRes;
import com.meetdoc.db.entity.*;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public interface AppointmentService {
    List<MedicDepartment> getAllDepartment();
    Appointment createAppointment(AppointmentPostReq appointmentInfo);
    SymptomImage createSymptomImage(String photoUrl, Appointment appointment);
    Appointment getAppointmentById(int appointmentId);
    List<Doctor> searchDoctors(int departmentCode, String name, Pageable pageable);
    String getDepartmentNameById(int departmentId);
    List<AppointmentGetRes> getAppointments(String userId);
    List<AppointmentGetRes> getDoctorAppointments(String userId);
    List<Appointment> findAvailableTime(String doctorId, LocalDateTime time);
    void writePrescription(int appointmentId, PrescriptionPatchReq req);
    Appointment findAppointmentByAppointmentId(int appointmentId) throws NoSuchElementException;
    void deleteAppointment(Appointment appointment);
    void changeStatus(Appointment appointment, String status);
    List<LocalDateTime> getAvailableTimeList(String doctorId, LocalDateTime time, OpeningHours openingHour);
    Appointment getNextAppointment(User user);
    boolean isOpen(Appointment appointment);
}
