package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
public class NextAppointmentRes extends BaseResponseBody {
    String status;
    String appointmentTime;
    String doctorName;

    public static NextAppointmentRes of(Integer statusCode, String message, Appointment ap) {
        NextAppointmentRes res = new NextAppointmentRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setStatus(ap.getStatus());
        res.setAppointmentTime(ap.getAppointmentTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        res.setDoctorName(ap.getDoctor().getUser().getName());
        return res;
    }
}
