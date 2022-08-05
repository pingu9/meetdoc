package com.meetdoc.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AppointmentPostReq {
    @ApiModelProperty(name = "환자 아이디")
    String patientId;
    @ApiModelProperty(name = "의사 아이디")
    String doctorId;
    @ApiModelProperty(name = "증상 내용")
    String symptom;
    @ApiModelProperty(name = "진료과 이름")
    String departmentName;
    @ApiModelProperty(name = "진료 일자/시간")
    String appointmentTime;
    @ApiModelProperty(name = "진료비")
    BigDecimal charge;
    @ApiModelProperty(name = "증상 사진들")
    List<String> symptomImages;

}
