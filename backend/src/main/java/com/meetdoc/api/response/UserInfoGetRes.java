package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;

import com.meetdoc.db.entity.User;
import com.meetdoc.db.entity.UserInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 유저 상세정보 요청에 대한 응답값 정의.
 */
@Getter
@Setter
@ApiModel("UserInfoGetRes")
public class UserInfoGetRes extends BaseResponseBody{
    @ApiModelProperty(name="유저 ID", example="your_id")
    String userId;
    @ApiModelProperty(name="유저 타입", example="의사일경우 doctor, 일반 회원일 경우 normal")
    String userType;
    @ApiModelProperty(name="유저 name", example="XXX")
    String userName;
    @ApiModelProperty(name="유저 성별", example="male")
    String gender;
    @ApiModelProperty(name="유저 생년월일", example="2000-01-01")
    String birthdate;
    @ApiModelProperty(name="유저 비밀번호", example="Ie923Cue323")
    String password;
    @ApiModelProperty(name="주민등록번호", example="200101-1111111")
    String rrn;
    @ApiModelProperty(name="우편번호", example="123-456")
    String zipcode;
    @ApiModelProperty(name="상세 주소", example="XX아파트 X동 X호")
    String address;
    @ApiModelProperty(name="phone number", example="010-0000-0000")
    String phone;
    @ApiModelProperty(name="이메일(선택)", example="XXXXX@gmail.com")
    String email;

//    @ApiModelProperty(name="병원명", example="your_hospital_name")
//    String hospitalName;
//    @ApiModelProperty(name="병원 전화번호", example="010-0000-0000 or 02-000-0000")
//    String hospitalPhone;
//    @ApiModelProperty(name="진료과", example="소아과")
//    String department;
//    @ApiModelProperty(name="의사면허번호", example="901210-1111111")
//    String licenseNumber;
//    @ApiModelProperty(name="병원 설명", example="병원에 대한 설명")
//    String description;

    public static UserInfoGetRes of(Integer statusCode, String message, User user) {
        UserInfo userInfo = user.getUserInfo();
        UserInfoGetRes res = new UserInfoGetRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);

        res.setUserId(user.getUserId());
        res.setUserType(user.getUserType());
        res.setUserName(user.getName());
        res.setGender(user.getGender());
        res.setBirthdate(user.getBirthdate().toString());

        res.setPassword(userInfo.getPassword());
        res.setRrn(userInfo.getRrn());
        res.setZipcode(userInfo.getZipcode());
        res.setAddress(userInfo.getAddress());
        res.setPhone(userInfo.getPhone());
        res.setEmail(userInfo.getEmail() == null ? "이메일 정보가 없습니다." : userInfo.getEmail());
        return res;
    }
}
