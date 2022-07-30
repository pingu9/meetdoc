package com.meetdoc.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrescriptionPatchReq {
    @ApiModelProperty(name = "처방 날짜")
    String prescriptionDate;
    @ApiModelProperty(name = "처방 내용")
    String prescriptionDescription;
    @ApiModelProperty(name = "질병 코드")
    String icd;
}
