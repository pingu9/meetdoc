package com.meetdoc.api.service;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;
import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.db.entity.User;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface UserService {
    User createUser(UserPostReq userRegisterInfo);
    User getUserByUserId(String userId);
    UserInfo getUserInfoByUserId(String userId);
    Doctor createDoctor(DoctorPostReq doctorInfo);
    Long updateUserByUserId(String userId, UserPatchReq patchUserReq);
    Long deleteUserByUserId(String userId);
}
