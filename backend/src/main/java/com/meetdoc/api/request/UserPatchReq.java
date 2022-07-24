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
@ApiModel("UserPatchReq")
public class UserPatchReq {
    @ApiModelProperty(name="유저 타입", example="의사일경우 D, 일반 회원일 경우 U")
    String userType;
    @ApiModelProperty(name="유저 ID", example="your_id")
    String id;
    @ApiModelProperty(name="유저 Password", example="your_password")
    String pw;
    @ApiModelProperty(name="유저 name", example="XXX")
    String name;
    @ApiModelProperty(name="주민등록번호", example="200101-1111111")
    String rrn;
    @ApiModelProperty(name="phone number", example="010-0000-0000")
    String phoneNumber;
    @ApiModelProperty(name="우편번호", example="123-456")
    String zipCode;
    @ApiModelProperty(name="상세 주소", example="XX아파트 X동 X호")
    String address;
    @ApiModelProperty(name="이메일(선택)", example="XXXXX@gmail.com")
    String email;

    @ApiModelProperty(name="생년월일", example="2000-01-01")
    LocalDate birthDate;

    @ApiModelProperty(name="성별", example="male/female")
    String gender;

    @ApiModelProperty(name="병원명", example="your_hospital_name")
    String hospitalName;
    @ApiModelProperty(name="병원 전화번호", example="010-0000-0000 or 02-000-0000")
    String hospitalPhone;
    @ApiModelProperty(name="진료과", example="소아과")
    String department;
    @ApiModelProperty(name="의사면허번호", example="901210-1111111")
    String licenseNumber;
    @ApiModelProperty(name="병원 설명", example="병원에 대한 설명")
    String description;


}
