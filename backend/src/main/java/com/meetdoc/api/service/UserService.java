package com.meetdoc.api.service;

import com.meetdoc.db.entity.User;

public interface UserService {
    User getUserByUserId(String userId);
}

