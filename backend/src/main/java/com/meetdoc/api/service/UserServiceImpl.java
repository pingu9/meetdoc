package com.meetdoc.api.service;

import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;
import com.meetdoc.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

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
        return userRepository.findByUserId(userId).get();
    }
}
