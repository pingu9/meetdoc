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
    int page;
    @ApiModelProperty(name="페이지 당 size", example="20")
    int size;

    public Pageable buildPageable() {
        return PageRequest.of(page, size, Sort.Direction.ASC, "name");
    }
}
