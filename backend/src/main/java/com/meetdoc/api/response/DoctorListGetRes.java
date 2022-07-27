package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.common.model.response.DoctorInfoResBody;
import com.meetdoc.db.entity.Doctor;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DoctorListGetRes extends BaseResponseBody {
    List<DoctorInfoResBody> result = new ArrayList<>();

    public void buildDoctorInfoList(List<Doctor> doctors, String departmentName) {

        for (Doctor doctor : doctors) {
            result.add(DoctorInfoResBody
                    .builder()
                    .userId(doctor.getUserId())
                    .name(doctor.getUser().getName())
                    .hospitalName(doctor.getHospitalName())
                    .departmentName(departmentName)
                    .build());
        }
    }

    public static DoctorListGetRes of(Integer statusCode, String message, String departmentName, List<Doctor> doctors) {
        DoctorListGetRes res = new DoctorListGetRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.buildDoctorInfoList(doctors, departmentName);

        return res;
    }
}
