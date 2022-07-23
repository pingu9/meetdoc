package com.meetdoc.api.service;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.User;

public interface UserService {
    User getUserByUserId(String userId);
    Doctor createDoctor(DoctorPostReq doctorInfo);
}

