package com.meetdoc.api.service;

import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;

public interface UserService {
    User getUserByUserId(String userId);
    UserInfo getUserInfoByUserId(String userId);
}

