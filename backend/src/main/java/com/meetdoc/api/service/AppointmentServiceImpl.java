package com.meetdoc.api.service;

import com.meetdoc.api.request.AppointmentPostReq;
import com.meetdoc.api.request.PrescriptionPatchReq;
import com.meetdoc.api.response.AppointmentGetRes;
import com.meetdoc.common.util.AvailableTimeStore;
import com.meetdoc.db.entity.*;
import com.meetdoc.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepositorySupport doctorRepositorySupport;
    @Autowired
    UserRepositorySupport userRepositorySupport;
    @Autowired
    AppointmentRepositorySupport appointmentRepositorySupport;
    @Autowired
    SymptomImageRepository symptomImageRepository;

    @Override
    public List<MedicDepartment> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Appointment createAppointment(AppointmentPostReq req) {
        Appointment appointment = new Appointment();
        User user = userRepositorySupport.findUserByUserId(req.getPatientId()).get();
        if(user == null) return null;
        Doctor doctor = userRepositorySupport.findUserByUserId(req.getDoctorId()).get().getDoctor();
        if(doctor == null) return null;
        appointment.setUser(user);
        appointment.setDoctor(doctor);

        if(req.getAppointmentTime() != null){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            appointment.setAppointmentTime(LocalDateTime.parse(req.getAppointmentTime(),formatter));
        } else return null;

        if(req.getCharge() == null) appointment.setCharge(BigDecimal.valueOf(0));
        else appointment.setCharge(req.getCharge());
        if(req.getSymptom() == null) return null;
        appointment.setSymptom(req.getSymptom());
        if(req.getDepartmentName() == null) return null;
        appointment.setDepartmentName(req.getDepartmentName());

        appointment.setStatus("Before");
        return appointmentRepository.save(appointment);
    }

    @Override
    public SymptomImage createSymptomImage(String photoUrl, Appointment appointment) {
        SymptomImage symptomImage = new SymptomImage();
        symptomImage.setPhotoUrl(photoUrl);
        symptomImage.setAppointment(appointment);
        return symptomImageRepository.save(symptomImage);
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentRepository.getOne(appointmentId);
    }

    @Override
    public List<Doctor> searchDoctors(int departmentCode, String name, Pageable pageable) {
        return doctorRepositorySupport.findDoctorsByDepartmentIdAndPageInfo(departmentCode, name, pageable);
    }

    @Override
    public String getDepartmentNameById(int departmentId) {
        return departmentRepository
                .findById(departmentId)
                .get()
                .getDepartmentName();
    }

    public List<AppointmentGetRes> getAppointments(String userId) {
        User user = userRepositorySupport.findUserByUserId(userId).get();
        if(user.getUserType().equals("D")) return null;
        List<AppointmentGetRes> list = new ArrayList<>();
        List<Appointment> appointments = (List<Appointment>) user.getAppointments();
        Collections.sort(appointments, (a,b) -> {
            if(a.getAppointmentTime().isAfter(b.getAppointmentTime())) return -1;
            else return 1;
        });
        for(Appointment ap : appointments){
            AppointmentGetRes res = new AppointmentGetRes();
            res.setAppointmentId(ap.getAppointmentId());
            res.setDoctorName(ap.getDoctor().getUser().getName());
            res.setAppointmentTime(ap.getAppointmentTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            res.setStatus(ap.getStatus());
            res.setDepartmentName(ap.getDepartmentName());
            res.setPatientName(user.getName());
            res.setRoomLink(ap.getRoomLink());
            res.setPhotoUrl(ap.getDoctor().getPhotoUrl());
            list.add(res);
        }
        return list;
    }

    @Override
    public List<AppointmentGetRes> getDoctorAppointments(String userId) {
        User user = userRepositorySupport.findUserByUserId(userId).get();
        if(!user.getUserType().equals("D")) return null;
        Doctor doctor = user.getDoctor();
        List<AppointmentGetRes> list = new ArrayList<>();
        List<Appointment> appointments = (List<Appointment>) doctor.getAppointments();
        Collections.sort(appointments, (a,b) -> {
            if(a.getAppointmentTime().isAfter(b.getAppointmentTime())) return -1;
            else return 1;
        });
        for(Appointment ap : appointments){
            AppointmentGetRes res = new AppointmentGetRes();
            res.setAppointmentId(ap.getAppointmentId());
            res.setDoctorName(user.getName());
            res.setAppointmentTime(ap.getAppointmentTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            res.setStatus(ap.getStatus());
            res.setDepartmentName(ap.getDepartmentName());
            res.setPatientName(ap.getUser().getName());
            res.setRoomLink(ap.getRoomLink());
            res.setPhotoUrl(doctor.getPhotoUrl());
            list.add(res);
        }
        return list;
    }

    @Override
    public List<Appointment> findAvailableTime(String doctorId, LocalDateTime time) {
        return appointmentRepositorySupport.findAppointmentByDoctorIdAndDate(doctorId, time);
    }

    @Override
    public void writePrescription(int appointmentId, PrescriptionPatchReq req) {
        Appointment appointment = appointmentRepository.getOne(appointmentId);
        appointment.setPrescriptionDescription(req.getPrescriptionDescription());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        appointment.setAppointmentTime(LocalDateTime.parse(req.getPrescriptionDate(),formatter));
        appointment.setIcd(req.getIcd());

        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment findAppointmentByAppointmentId (int appointmentId) throws NoSuchElementException {
        return appointmentRepository.findById(appointmentId).get();
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    @Override
    public List<LocalDateTime> getAvailableTimeList(String doctorId, LocalDateTime time, OpeningHours openingHour) {
        AvailableTimeStore timeStore = new AvailableTimeStore(openingHour, time.toLocalDate());

        List<Appointment> appointmentList = findAvailableTime(doctorId, time);

        for (Appointment appointment : appointmentList) {
            timeStore.book(appointment.getAppointmentTime());
        }

        return timeStore.getAvailableTimeList();
    }
}
