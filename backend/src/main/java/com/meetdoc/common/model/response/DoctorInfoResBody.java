package com.meetdoc.common.model.response;

import com.meetdoc.db.entity.MedicDepartment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@ApiModel("DoctorInfoBody")
public class DoctorInfoResBody {
    @ApiModelProperty(name="유저 id", example="user_id")
    String userId;
    @ApiModelProperty(name="유저 name", example="user_name")
    String name;
    @ApiModelProperty(name="병원명", example="your_hospital_name")
    String hospitalName;
    @ApiModelProperty(name="진료과", example="소아과")
    String departmentName;
}
