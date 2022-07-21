package com.meetdoc.db.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserInfo {
    @NotNull
    String password;
    @NotNull
    String RRN;
    @NotNull
    String zipcode;
    @NotNull
    String address;
    @NotNull
    String phone;
    String email;

    @OneToOne(fetch = FetchType.LAZY)
    @Id
    @JoinColumn(name = "userId")
    User user;
}
