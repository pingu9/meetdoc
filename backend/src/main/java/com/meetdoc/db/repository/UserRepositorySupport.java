package com.meetdoc.db.repository;

import com.meetdoc.db.entity.QUserInfo;
import com.meetdoc.db.entity.UserInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.meetdoc.db.entity.QUser;
import com.meetdoc.db.entity.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class UserRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QUser qUser = QUser.user;
    QUserInfo qUserInfo = QUserInfo.userInfo;

    public Optional<User> findUserByUserId(String userId) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.userId.eq(userId)).fetchOne();
        if (user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }

    public Optional<UserInfo> findUserInfoByUserId(String userId) {
        UserInfo userInfo = jpaQueryFactory.select(qUserInfo).from(qUserInfo)
                .where(qUser.userId.eq(userId)).fetchOne();
        if (userInfo == null) return Optional.empty();
        return Optional.ofNullable(userInfo);
    }
}
