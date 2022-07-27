package com.meetdoc.api.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ApiModel("DoctorListGetRequest")
public class DoctorListGetReq {
    @ApiModelProperty(name="페이지 번호", example="1")
    int page = 0;
    @ApiModelProperty(name="페이지 당 size", example="20")
    int size = 20;

    @ApiModelProperty(name="의사 이름을 통한 검색(Optional)", example="doctor_name")
    String name;

    public Pageable buildPageable() {
        return PageRequest.of(page, size, Sort.Direction.ASC, "name");
    }
}
