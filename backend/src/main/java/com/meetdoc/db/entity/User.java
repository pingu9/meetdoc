package com.meetdoc.db.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class User {
    @Id
    String userId;
    String userType;
    String name;
    String password;
    String gender;
    LocalDateTime birthdate;
    String status;

    @OneToOne(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    UserInfo userInfo;

    @OneToOne(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    Doctor doctor;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    Collection<Appointment> appointments = new ArrayList<>();
}
