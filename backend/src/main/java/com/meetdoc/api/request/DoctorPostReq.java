package com.meetdoc.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 의사 회원가입 요청에 필요한 request body 정의.
 */
@Getter
@Setter
@ApiModel("DoctorPostRequest")
public class DoctorPostReq {
    @ApiModelProperty(name="유저 ID", example="your_id")
    String userId;
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
