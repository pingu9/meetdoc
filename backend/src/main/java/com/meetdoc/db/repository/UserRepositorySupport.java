package com.meetdoc.db.repository;

import com.meetdoc.api.request.UserPatchReq;
import com.meetdoc.db.entity.QUserInfo;
import com.meetdoc.db.entity.UserInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.meetdoc.db.entity.QUser;
import com.meetdoc.db.entity.User;

import java.util.Optional;

import com.querydsl.jpa.impl.JPAUpdateClause;
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
                .where(qUserInfo.userId.eq(userId)).fetchOne();
        if (userInfo == null) return Optional.empty();
        return Optional.ofNullable(userInfo);
    }

    public Long updateUserByUserId(String userId, UserPatchReq patchUserReq) {
        Long affectedRow = jpaQueryFactory.update(qUserInfo)
                .where(qUser.userId.eq(userId))
                .set(QUserInfo.userInfo.password, patchUserReq.getPassword())
                .set(QUserInfo.userInfo.password, patchUserReq.getZipcode())
                .set(QUserInfo.userInfo.password, patchUserReq.getZipcode())
                .set(QUserInfo.userInfo.password, patchUserReq.getAddress())
                .set(QUserInfo.userInfo.password, patchUserReq.getEmail())
                .execute();
        return affectedRow;
    }
}
