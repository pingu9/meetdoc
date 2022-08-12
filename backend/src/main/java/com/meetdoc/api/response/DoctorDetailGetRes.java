package com.meetdoc.api.response;

import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.DoctorMedicDepartment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DoctorDetailGetRes extends BaseResponseBody {
    @ApiModelProperty(name = "유저 ID")
    String doctorId;
    @ApiModelProperty(name = "의사 자격 번호")
    String licenseNumber;
    @ApiModelProperty(name = "병원 이름")
    String hospitalName;
    @ApiModelProperty(name = "병원 전화번호")
    String hospitalPhone;
    @ApiModelProperty(name = "병원 우편번호")
    String hospitalZipcode;
    @ApiModelProperty(name = "병원 주소")
    String hospitalAddress;
    @ApiModelProperty(name = "병원 소개")
    String hospitalDescription;
    @ApiModelProperty(name = "진료비")
    BigDecimal charge;
    @ApiModelProperty(name = "사진 URL")
    String photoUrl;
    @ApiModelProperty(name = "진료과")
    List<String> departmentNames;

    public static DoctorDetailGetRes of(Integer statusCode, String message, Doctor doctor) {
        DoctorDetailGetRes res = new DoctorDetailGetRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);

        res.setDoctorId(doctor.getUserId());
        res.setLicenseNumber(doctor.getLicenseNumber());
        res.setHospitalName(doctor.getHospitalName());
        res.setHospitalZipcode(doctor.getHospitalZipcode());
        res.setHospitalAddress(doctor.getHospitalAddress());
        res.setHospitalPhone(doctor.getHospitalPhone());
        res.setHospitalDescription(doctor.getHospitalDescription());
        res.setCharge(doctor.getCharge());
        res.setPhotoUrl(doctor.getPhotoUrl());

        List<DoctorMedicDepartment> list = (List<DoctorMedicDepartment>) doctor.getDoctorMedicDepartments();
        List<String> departments = new ArrayList<>();
        for(DoctorMedicDepartment dmd : list) {
            departments.add(dmd.getMedicDepartment().getDepartmentName());
        }
        res.setDepartmentNames(departments);
        return res;
    }
}
