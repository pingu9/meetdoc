package com.meetdoc.common.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel("DoctorInfoBody")
public class DoctorInfoResBody {
    @ApiModelProperty(name="유저 id", example="user_id")
    String doctorId;
    @ApiModelProperty(name="유저 name", example="user_name")
    String doctorName;
    @ApiModelProperty(name="병원명", example="your_hospital_name")
    String hospitalName;
    @ApiModelProperty(name="진료과", example="소아과")
    String departmentName;
    @ApiModelProperty(name = "사진 URL")
    String photoUrl;
}
