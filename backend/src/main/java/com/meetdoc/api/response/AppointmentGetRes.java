package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Appointment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class AppointmentGetRes extends BaseResponseBody {
    @ApiModelProperty(name = "환자 이름")
    String patientName;
    @ApiModelProperty(name = "의사 이름")
    String doctorName;
    @ApiModelProperty(name = "진료 아이디")
    int appointmentId;
    @ApiModelProperty(name = "진료 예약 시간")
    String appointmentTime;
    @ApiModelProperty(name = "진료 상태")
    String status;
    @ApiModelProperty(name = "진료비")
    BigDecimal charge;
    @ApiModelProperty(name = "진료과 이름")
    String departmentName;
    @ApiModelProperty(name = "화상 진료 링크")
    String roomLink;
    @ApiModelProperty(name = "사진 URL")
    String photoUrl;

    public static AppointmentGetRes of(Integer statusCode, String message, Appointment appointment) {
        AppointmentGetRes res = new AppointmentGetRes();

        res.setStatusCode(statusCode);
        res.setMessage(message);

        res.setAppointmentId(appointment.getAppointmentId());
        res.setDepartmentName(appointment.getDepartmentName());
        res.setPatientName(appointment.getUser().getName());
        res.setDoctorName(appointment.getDoctor().getUser().getName());
        res.setStatus(appointment.getStatus());
        res.setAppointmentTime(appointment.getAppointmentTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        res.setCharge(appointment.getCharge());

        res.setRoomLink(appointment.getRoomLink());
        res.setPhotoUrl(appointment.getDoctor().getPhotoUrl());

        return res;
    }
}
