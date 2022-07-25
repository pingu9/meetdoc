package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;

/**
 * 유저 상세정보 모델 정의
 */
@Entity
@Getter
@Setter
public class UserInfo implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;

    @NotNull
    String password;
    @NotNull
    String rrn;
    @NotNull
    String zipcode;
    @NotNull
    String address;
    @NotNull
    String phone;
    String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    User user;
}
