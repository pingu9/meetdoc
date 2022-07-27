package com.meetdoc.api.controller;

import com.meetdoc.api.response.AppointmentDetailGetRes;
import com.meetdoc.api.response.AppointmentGetRes;
import com.meetdoc.api.response.DoctorDetailGetRes;
import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "예약 API", tags = {"Appointment"})
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    UserService userService;

    @GetMapping("/departments")
    @ApiOperation(value = "진료과 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDepartments() {
        List<MedicDepartment> list = appointmentService.getAllDepartment();
        if(!list.isEmpty()) return ResponseEntity.status(200).body(list);
        else return ResponseEntity.status(200).body(BaseResponseBody.of(500, "데이터를 가져오는 중 문제가 발생했습니다."));
    }

    @GetMapping("/info/list/{userId}")
    @ApiOperation(value = "예약한 진료 리스트(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "환자가 아닌 회원"),
            @ApiResponse(code = 404, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentList(@PathVariable String userId) {
        List<AppointmentGetRes> list = appointmentService.getAppointments(userId);
        if(list == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "환자가 아닌 회원입니다."));
        if(list.size() > 0) return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body(BaseResponseBody.of(404, "진료 내역이 없습니다."));
    }

    @GetMapping("/info/list/doctor/{userId}")
    @ApiOperation(value = "예약한 진료 리스트(의사)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "의사가 아닌 회원"),
            @ApiResponse(code = 404, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorAppointmentList(@PathVariable String userId) {
        List<AppointmentGetRes> list = appointmentService.getDoctorAppointments(userId);
        if(list == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401,"의사가 아닌 회원입니다."));
        if(list.size() > 0) return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body(BaseResponseBody.of(404, "진료 내역이 없습니다."));
    }

    @GetMapping("/info/detail/{appointmentId}")
    @ApiOperation(value = "진료 상세 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentDetail(@PathVariable int appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if(appointment == null)
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"진료 내역이 존재하지 않습니다."));
        return ResponseEntity.status(200).body(AppointmentDetailGetRes.of(200,"Success",appointment));
    }
}
