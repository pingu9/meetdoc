package com.meetdoc.api.service;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;

public interface UserService {
    User getUserByUserId(String userId);
    UserInfo getUserInfoByUserId(String userId);

    Doctor createDoctor(DoctorPostReq doctorInfo);

    Long updateUserByUserId(String userId, UserPatchReq patchUserReq);
    Long deleteUserByUserId(String userId);
}

