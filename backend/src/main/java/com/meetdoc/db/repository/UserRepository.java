package com.meetdoc.db.repository;

import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    Optional<UserInfo> findUserInfoByUserId(String userId);
}