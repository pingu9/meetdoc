package com.meetdoc.api.controller;

import com.meetdoc.api.request.DoctorListGetReq;
import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.api.request.OpeningHourPostReq;
import com.meetdoc.api.response.DoctorDetailGetRes;
import com.meetdoc.api.response.DoctorListGetRes;
import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.DoctorService;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "의사 API", tags = {"Doctor"})
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    UserService userService;
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/regist")
    @ApiOperation(value = "의사 회원가입", notes = "의사 회원의 경우 필요한 항목들을 추가 입력한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })
    public ResponseEntity<? extends BaseResponseBody> doctorRegister(
            @RequestBody @ApiParam(value = "회원가입", required = true) DoctorPostReq registerInfo) {
        Doctor doctor = doctorService.createDoctor(registerInfo);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PostMapping("/openingHours")
    @ApiOperation(value = "의사 진료 가능 시간 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })
    public  ResponseEntity<? extends  BaseResponseBody> setOpeningHours(@RequestBody OpeningHourPostReq req) {
        doctorService.setOpeningHours(req.getUserId(),req.getOpeningHours());
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/detail/{userId}")
    @ApiOperation(value = "의사 상세 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorDetail(@PathVariable  String userId) {
        User user = userService.getUserByUserId(userId);
        if(user == null)
            return ResponseEntity.status(404).body(BaseResponseBody.of(404, "존재하지 않는 회원입니다."));
        Doctor doctor = user.getDoctor();
        if (doctor == null) {
            return ResponseEntity.status(404).body(BaseResponseBody.of(401, "의사가 아닌 회원입니다."));
        } else return ResponseEntity.status(200).body(DoctorDetailGetRes.of(200,"Success",doctor));
    }

    @GetMapping("/list/{departmentId}")
    @ApiOperation(value = "페이지 숫자, 검색 쿼리를 적용한 ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "검색 조건, 페이징 등 에러"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorList(@PathVariable int departmentId, Pageable pageable, String name) {
        List<Doctor> doctorList = appointmentService.searchDoctors(departmentId, name, pageable);

        String departmentName = appointmentService.getDepartmentNameById(departmentId);

        if(doctorList.size() == 0)
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"해당 의사가 존재하지 않습니다."));
        return ResponseEntity.status(200).body(DoctorListGetRes.of(200,"Success", departmentName, doctorList));
    }
}
