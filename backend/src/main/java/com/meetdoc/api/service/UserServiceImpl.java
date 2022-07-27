package com.meetdoc.api.service;

import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.db.entity.*;
import com.meetdoc.db.repository.UserRepository;
import com.meetdoc.db.repository.DoctorMedicDepartmentRepositorySupport;
import com.meetdoc.db.repository.DoctorRepository;
import com.meetdoc.api.request.UserPatchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.meetdoc.db.repository.UserRepositorySupport;

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
    public User createUser(UserPostReq userReqInfo) {
        User user = new User();
        UserInfo userInfo = new UserInfo();

        user.setUserId(userReqInfo.getId());
        user.setName(userReqInfo.getName());
        user.setStatus("active");
        user.setUserType(userReqInfo.getUserType());
        user.setBirthdate(userReqInfo.getBirthDate());
        user.setGender(userReqInfo.getGender());

        userInfo.setPassword((passwordEncoder.encode(userReqInfo.getPw())));
        userInfo.setAddress(userReqInfo.getAddress());
        userInfo.setEmail(userReqInfo.getEmail());
        userInfo.setPhone(userReqInfo.getPhoneNumber());
        userInfo.setRrn(userReqInfo.getRrn());
        userInfo.setZipcode(userReqInfo.getZipCode());


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
        Long affectedRow = userRepositorySupport.updateUserByUserId(userId, patchUserReq);
        return affectedRow;
    }

    @Override
    public Long deleteUserByUserId(String userId) {
        Long affectedRow = userRepositorySupport.deleteUserByUserId(userId);
        return affectedRow;
    }
}
