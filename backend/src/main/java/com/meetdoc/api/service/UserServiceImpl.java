package com.meetdoc.api.service;

import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(UserPostReq userReqInfo) {
        User user = new User();
        user.setUserId(userReqInfo.getId());
        user.setPassword((userReqInfo.getPw()));
        user.setName(userReqInfo.getName());
        user.setStatus("active");
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findByUserId(userId).get();
    }
}
