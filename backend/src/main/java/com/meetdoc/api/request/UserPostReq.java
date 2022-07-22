package com.meetdoc.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 회원가입 요청에 필요한 request 정의.
 */
@Getter
@Setter
@ApiModel("UserPostRequest")
public class UserPostReq {
    @ApiModelProperty(name="유저 ID", example="your_id")
    String id;
    @ApiModelProperty(name="유저 Password", example="your_password")
    String pw;
    @ApiModelProperty(name="유저 name", example="XXX")
    String name;
    @ApiModelProperty(name="주민등록번호", example="200101-1111111")
    String RRN;

    @ApiModelProperty(name="phone number", example="010-0000-0000")
    String phoneNumber;
    @ApiModelProperty(name="우편번호", example="123-456")
    String zipCode;
    @ApiModelProperty(name="상세 주소", example="XX아파트 X동 X호")
    String address;
    @ApiModelProperty(name="이메일(선택)", example="XXXXX@gmail.com")
    String email;
}
