package com.meetdoc.api.service;

import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.meetdoc.db.entity.User;
import com.meetdoc.db.repository.UserRepository;
import com.meetdoc.db.repository.UserRepositorySupport;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositorySupport userRepositorySupport;

    @Autowired
    PasswordEncoder passwordEncoder;

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