package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Appointment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDetailGetRes extends BaseResponseBody {
    @ApiModelProperty(name = "진료 ID")
    int appointmentId;
    @ApiModelProperty(name = "환자 ID")
    String patientUserId;
    @ApiModelProperty(name = "의사 ID")
    String doctorUserId;
    @ApiModelProperty(name = "진료 날짜")
    LocalDateTime appointmentDate;
    @ApiModelProperty(name = "증상")
    String symptom;
    @ApiModelProperty(name = "진료비")
    BigDecimal charge;
    @ApiModelProperty(name = "진료 상태")
    String status;
//    @ApiModelProperty(name = "진료 화상 채팅방 링크")
//    String roomLink;
//    @ApiModelProperty(name = "의사 들어온 기록")
//    String enterDoctor;
//    @ApiModelProperty(name = "환자 들어온 기록")
//    String enterPatient;
//    @ApiModelProperty(name = "의사 나간 기록")
//    String leaveDoctor;
//    @ApiModelProperty(name = "환자 나간 기록")
//    String leavePatient;
    @ApiModelProperty(name = "질병 코드")
    String icd;
    @ApiModelProperty(name = "처방 날짜")
    LocalDateTime prescriptionDate;
    @ApiModelProperty(name = "처방 설명")
    String prescriptionDescription;
//    @ApiModelProperty(name = "정산 일자")
//    LocalDateTime settlementDate;

    public static AppointmentDetailGetRes of(Integer statusCode, String message, Appointment appointment) {
        AppointmentDetailGetRes res = new AppointmentDetailGetRes();

        res.setStatusCode(statusCode);
        res.setMessage(message);

        res.setAppointmentId(appointment.getAppointmentId());
        res.setDoctorUserId(appointment.getDoctor().getUserId());
        res.setPatientUserId(appointment.getUser().getUserId());
        res.setAppointmentId(appointment.getAppointmentId());
        res.setSymptom(appointment.getSymptom());
        res.setAppointmentDate(appointment.getAppointmentDate());
        res.setCharge(appointment.getCharge());
        res.setStatus(appointment.getStatus());
        res.setIcd(appointment.getIcd() == null ? "데이터 없음" : appointment.getIcd());
        res.setPrescriptionDate(appointment.getPrescriptionDate());
        res.setPrescriptionDescription(appointment.getPrescriptionDescription() == null ? "데이터 없음" : appointment.getPrescriptionDescription());

        return res;
    }
}
