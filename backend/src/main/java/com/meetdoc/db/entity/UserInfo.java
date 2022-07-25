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
<<<<<<< HEAD
    @JoinColumn(name = "user_id")
    @MapsId
=======
    @Id
    @MapsId
    @JoinColumn(name = "userId")
>>>>>>> 93514c0ee8d222a87b6d46a12c8a527e6d9d1117
    User user;
}
