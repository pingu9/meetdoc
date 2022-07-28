package com.meetdoc.api.service;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.DoctorMedicDepartment;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.entity.OpeningHours;
import com.meetdoc.db.repository.DoctorRepository;
import com.meetdoc.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(DoctorPostReq doctorInfo) {
        Doctor doctor = new Doctor();
        doctor.setUserId(doctorInfo.getDoctorId());
        doctor.setLicenseNumber(doctorInfo.getLicenseNumber());
        doctor.setHospitalName(doctorInfo.getHospitalName());
        doctor.setHospitalPhone(doctorInfo.getHospitalPhone());
        doctor.setHospitalZipcode(doctorInfo.getHospitalZipcode());
        doctor.setHospitalAddress(doctorInfo.getHospitalAddress());
        doctor.setHospitalDescription(doctorInfo.getHospitalDescription());
        doctor.setCharge(doctorInfo.getCharge());

        List<DoctorMedicDepartment> list = (List<DoctorMedicDepartment>) doctor.getDoctorMedicDepartments();
        for(MedicDepartment md : doctorInfo.getDepartments()){
            DoctorMedicDepartment doctorMedicDepartment = new DoctorMedicDepartment();
            doctorMedicDepartment.setDoctor(doctor);
            doctorMedicDepartment.setMedicDepartment(md);
            list.add(doctorMedicDepartment);
        }

        doctor.setUser(userRepository.findByUserId(doctorInfo.getDoctorId()).get());
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor setOpeningHours(String userId, List<OpeningHours> hours) {
        Doctor doctor = doctorRepository.getOne(userId);
        List<OpeningHours> list = (List<OpeningHours>) doctor.getOpeningHours();
        for(OpeningHours op : hours) {
            op.setDoctor(doctor);
            op.setOpen(calTime(op.getOpen()));
            op.setLunchHour(calTime(op.getLunchHour()));
            op.setClose(calTime(op.getClose()));
            list.add(op);
        }
        return doctorRepository.save(doctor);
    }

    public Date calTime(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.add(Calendar.HOUR,-9);
        return cal.getTime();
    }
}
