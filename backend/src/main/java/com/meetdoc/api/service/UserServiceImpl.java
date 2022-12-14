package com.meetdoc.api.service;

import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.db.entity.*;
import com.meetdoc.db.repository.*;
import com.meetdoc.api.request.UserPatchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

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

    @Autowired
    DayOffRepositorySupport dayOffRepositorySupport;

    @Autowired
    OpeningHoursRepositorySupport openingHoursRepositorySupport;

    @Override
    public User createUser(UserPostReq userReqInfo) {
        User user = new User();
        UserInfo userInfo = new UserInfo();

        String rrn = userReqInfo.getRrn();
        String birth = "19"+rrn.substring(0,2)+"-"+rrn.substring(2,4)+"-"+rrn.substring(4,6);
        String gender = Integer.parseInt(rrn.substring(6,7))%2 != 0 ? "male" : "female";
        LocalDate birthDate = LocalDate.parse(birth);
        System.out.println(birthDate);
        System.out.println(gender);

        user.setUserId(userReqInfo.getUserId());
        user.setName(userReqInfo.getUserName());
        user.setStatus("active");
        user.setUserType(userReqInfo.getUserType());
        user.setBirthdate(birthDate);
        user.setGender(gender);

        userInfo.setPassword((passwordEncoder.encode(userReqInfo.getPassword())));
        userInfo.setAddress(userReqInfo.getAddress());
        userInfo.setEmail(userReqInfo.getEmail());
        userInfo.setPhone(userReqInfo.getPhone());
        userInfo.setRrn(userReqInfo.getRrn());
        userInfo.setZipcode(userReqInfo.getZipcode());

        userInfo.setUser(user);
        user.setUserInfo(userInfo);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserId(String userId) {
        User user = userRepositorySupport.findUserByUserId(userId).get();
        return user;
    }

    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        UserInfo userInfo = userRepositorySupport.findUserInfoByUserId(userId).get();
        return userInfo;
    }

    @Override
    public Long updateUserByUserId(String userId, UserPatchReq patchUserReq) {
        if(patchUserReq.getPassword() != null && !patchUserReq.getPassword().equals(""))
            patchUserReq.setPassword((passwordEncoder.encode(patchUserReq.getPassword())));
        Long affectedRow = userRepositorySupport.updateUserByUserId(userId, patchUserReq);
        return affectedRow;
    }

    @Override
    public Long deleteUserByUserId(String userId) {
        Long affectedRow = userRepositorySupport.deleteUserByUserId(userId);
        return affectedRow;
    }

    @Override
    public Boolean isDayOff(String userId, LocalDate localDate) {
        try {
            DayOff dayoff =  dayOffRepositorySupport.findDayOffByIdAndDate(userId, localDate).get();
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public OpeningHours getOpeningHoursByIdAndWeekDay(String userId, String weekDay) {
        return openingHoursRepositorySupport.findOpeningHourByIdAndWeekDay(userId, weekDay).get();
    }

    @Override
    public Boolean isDoctor(User user) {
        if (user == null) {
            return false;
        }
        if (!user.getUserType().equals("D")) {
            return false;
        }
        if (user.getDoctor() == null) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean isPatient(User user) {
        if (user == null) {
            return false;
        }
        if (!user.getUserType().equals("U")) {
            return false;
        }

        return true;
    }
}
