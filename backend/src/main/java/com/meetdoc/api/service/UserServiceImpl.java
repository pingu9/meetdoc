package com.meetdoc.api.service;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.DoctorMedicDepartment;
import com.meetdoc.db.repository.DoctorMedicDepartmentRepositorySupport;
import com.meetdoc.db.repository.DoctorRepository;
import com.meetdoc.db.repository.UserRepository;
import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.meetdoc.db.entity.User;
import com.meetdoc.db.repository.UserRepositorySupport;

import java.util.ArrayList;
import java.util.List;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositorySupport userRepositorySupport;

    @Autowired
    DoctorMedicDepartmentRepositorySupport doctorMedicDepartmentRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User getUserByUserId(String userId) {
        User user = userRepositorySupport.findUserByUserId(userId).get();
        return user;
    }

    @Override
    public Doctor createDoctor(DoctorPostReq doctorInfo) {
        Doctor doctor = new Doctor();
        doctor.setUserId(doctorInfo.getUserId());
        doctor.setLicenseNumber(doctorInfo.getLicenseNumber());
        doctor.setHospitalName(doctorInfo.getHospitalName());
        doctor.setHospitalPhone(doctorInfo.getHospitalPhone());
        doctor.setHospitalZipcode(doctorInfo.getHospitalZipcode());
        doctor.setHospitalAddress(doctorInfo.getHospitalAddress());
        doctor.setHospitalDescription(doctorInfo.getHospitalDescription());
        doctor.setCharge(doctorInfo.getCharge());
        List<DoctorMedicDepartment> list = (List<DoctorMedicDepartment>) doctor.getDoctorMedicDepartments();
        for(int i=0; i<doctorInfo.getDepartments().size(); ++i){
            System.out.println(doctorInfo.getDepartments().get(i));
            DoctorMedicDepartment doctorMedicDepartment = new DoctorMedicDepartment();
            doctorMedicDepartment.setDoctor(doctor);
            doctorMedicDepartment.setMedicDepartment(doctorInfo.getDepartments().get(i));
            list.add(doctorMedicDepartment);
        }
        doctor.setUser(userRepository.findByUserId(doctorInfo.getUserId()).get());
        return doctorRepository.save(doctor);
    }

    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        UserInfo userInfo = userRepositorySupport.findUserInfoByUserId(userId).get();
        return userInfo;
    }

    @Override
    public Long updateUserByUserId(String userId, UserPatchReq patchUserReq) {
        Long affectedRow = userRepositorySupport.updateUserByUserId(userId, patchUserReq);
        return affectedRow;
    }

    @Override
    public Long deleteUserByUserId(String userId) {
        Long affectedRow = userRepositorySupport.deleteUserByUserId(userId);
        return affectedRow;
    }
}