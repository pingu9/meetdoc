package com.meetdoc.api.service;

import com.meetdoc.api.response.AppointmentGetRes;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.repository.AppointmentRepository;
import com.meetdoc.db.repository.DepartmentRepository;
import com.meetdoc.db.repository.DoctorRepositorySupport;
import com.meetdoc.db.repository.UserRepository;
import com.meetdoc.db.repository.UserRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<MedicDepartment> getAllDepartment() {
        return departmentRepository.findAll();
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
        for(Appointment ap : appointments){
            AppointmentGetRes res = new AppointmentGetRes();
            res.setAppointmentId(ap.getAppointmentId());
            res.setDoctorName(ap.getDoctor().getUser().getName());
            res.setAppointmentTime(ap.getAppointmentDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            res.setStatus(ap.getStatus());
            res.setDepartmentName(ap.getDepartmentName());
            res.setUserName(user.getName());
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
        for(Appointment ap : appointments){
            AppointmentGetRes res = new AppointmentGetRes();
            res.setAppointmentId(ap.getAppointmentId());
            res.setDoctorName(user.getName());
            res.setAppointmentTime(ap.getAppointmentDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            res.setStatus(ap.getStatus());
            res.setDepartmentName(ap.getDepartmentName());
            res.setUserName(ap.getUser().getName());
            res.setRoomLink(ap.getRoomLink());
            res.setPhotoUrl(doctor.getPhotoUrl());
            list.add(res);
        }
        return list;
    }
}
