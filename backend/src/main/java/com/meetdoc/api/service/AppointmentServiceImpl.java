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
}

    public List<AppointmentGetRes> getAppointments(String userId) {
        User user = userRepositorySupport.findUserByUserId(userId).get();
        List<AppointmentGetRes> list = new ArrayList<>();
        List<Appointment> appointments = (List<Appointment>) user.getAppointments();
        for(Appointment ap : appointments){
            AppointmentGetRes res = new AppointmentGetRes();
            res.setAppointmentId(ap.getAppointmentId());
            res.setDoctorName(ap.getDoctor().getUser().getName());
            res.setAppointmentTime(ap.getAppointmentDate());
            res.setStatus(ap.getStatus());
            res.setUserName(user.getName());
            res.setRoomLink(ap.getRoomLink());
            list.add(res);
        }
        return list;
    }
}
