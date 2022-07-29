package com.meetdoc.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 유저 회원가입 요청에 필요한 request 정의.
 */
@Getter
@Setter
@ApiModel("UserPostRequest")
public class UserPostReq {
    @ApiModelProperty(name="유저 ID", example="your_id")
    String userId;
    @ApiModelProperty(name="유저 Password", example="your_password")
    String password;

    @ApiModelProperty(name="유저 type", example="doctor일때 D, 일반 유저일때 U")
    String userType;
    @ApiModelProperty(name="유저 name", example="XXX")
    String userName;
    @ApiModelProperty(name="주민등록번호", example="200101-1111111")
    String rrn;
    @ApiModelProperty(name="생년월일", example="2000-01-01")
    LocalDate birthdate;
    @ApiModelProperty(name="성별", example="male/female")
    String gender;

    @ApiModelProperty(name="phone number", example="010-0000-0000")
    String phone;
    @ApiModelProperty(name="우편번호", example="123-456")
    String zipcode;
    @ApiModelProperty(name="상세 주소", example="XX아파트 X동 X호")
    String address;
    @ApiModelProperty(name="이메일(선택)", example="XXXXX@gmail.com")
    String email;
}
