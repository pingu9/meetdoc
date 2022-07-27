package com.meetdoc.api.request;

import com.meetdoc.db.entity.OpeningHours;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel("OpeningHourPostReq")
public class OpeningHourPostReq {
    @ApiModelProperty(name="병원 우편번호", example="user4")
    String userId;
    @ApiModelProperty(name="진료 가능 일자/시간", example="[{open: 09:00, lunch_hour: 12:00, close: 18:00, startDate: 2022-07-26, dayOfTheWeek: Mon}]")
    List<OpeningHours> openingHours;
}
