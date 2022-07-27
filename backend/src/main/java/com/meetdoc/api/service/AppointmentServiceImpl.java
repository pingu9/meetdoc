package com.meetdoc.api.service;

import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.repository.AppointmentRepository;
import com.meetdoc.db.repository.DepartmentRepository;
import com.meetdoc.db.repository.DoctorRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepositorySupport doctorRepositorySupport;

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
}