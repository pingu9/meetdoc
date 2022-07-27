package com.meetdoc.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentGetRes {
    @ApiModelProperty(name = "환자 이름")
    String userName;
    @ApiModelProperty(name = "의사 이름")
    String doctorName;
    @ApiModelProperty(name = "진료 아이디")
    int appointmentId;
    @ApiModelProperty(name = "진료 예약 시간")
    String appointmentTime;
    @ApiModelProperty(name = "진료 상태")
    String status;
    @ApiModelProperty(name = "진료과 이름")
    String departmentName;
    @ApiModelProperty(name = "화상 진료 링크")
    String roomLink;
    @ApiModelProperty(name = "사진 URL")
    String photoUrl;
}
