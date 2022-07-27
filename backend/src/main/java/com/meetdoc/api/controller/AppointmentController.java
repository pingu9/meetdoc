package com.meetdoc.api.controller;

import com.meetdoc.api.request.AppointmentPostReq;
import com.meetdoc.api.request.DoctorListGetReq;
import com.meetdoc.api.response.*;
import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.common.model.response.DoctorInfoResBody;
import com.meetdoc.common.util.AvailableTimeStore;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityExistsException;
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

    @PostMapping("/reserve")
    @ApiOperation(value = "진료과 리스트")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 407, message = "중복 진료 내역"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> reserveAppointment(@RequestBody AppointmentPostReq req) {
        try {
            appointmentService.createAppointment(req);
        } catch (EntityExistsException e) {
            return ResponseEntity.status(407).body(BaseResponseBody.of(407, "이미 존재하는 진료 아이디입니다."));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
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
            @ApiResponse(code = 404, message = "존재하지 않는 의사"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentDetail(@PathVariable int appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if(appointment == null)
            return ResponseEntity.status(404).body(BaseResponseBody.of(404,"진료 내역이 존재하지 않습니다."));
        return ResponseEntity.status(200).body(AppointmentDetailGetRes.of(200,"Success",appointment));
    }


    @GetMapping("/available-time/{doctorId}")
    @ApiOperation(value = "가능 시간")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 404, message = "존재하지 않는 의사"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAvailableTimeList(@PathVariable String doctorId, String date) {

        AvailableTimeStore timeStore = new AvailableTimeStore();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime time = LocalDateTime.of(LocalDate.parse(date, formatter), LocalTime.of(0, 0));
        timeStore.init(time.toLocalDate());

        List<Appointment> appointmentList = appointmentService.findAvailableTime(doctorId, time);

        for (Appointment appointment : appointmentList) {
           timeStore.book(appointment.getAppointmentDate());
        }

        List<LocalDateTime> timeList = timeStore.getAvailableTimeList();

        return ResponseEntity.status(200).body(AvailableTimeGetRes.of(200, "Success", timeList));
    }


}
