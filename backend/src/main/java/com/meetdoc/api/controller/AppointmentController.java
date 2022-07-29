package com.meetdoc.api.controller;

import com.meetdoc.api.request.AppointmentPostReq;
import com.meetdoc.api.request.PrescriptionPatchReq;
import com.meetdoc.api.response.*;
import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.auth.UserDetails;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.common.util.AvailableTimeStore;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.MedicDepartment;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.NoSuchElementException;

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
        else return ResponseEntity.status(500).body(BaseResponseBody.of(500, "데이터를 가져오는 중 문제가 발생했습니다."));
    }

    @PostMapping("/reserve")
    @ApiOperation(value = "진료 예약 요청")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 400, message = "잘못된 요청"),
            @ApiResponse(code = 409, message = "중복 진료 내역"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> reserveAppointment(@RequestBody AppointmentPostReq req) {
        try {
            Appointment ap = appointmentService.createAppointment(req);
            if(ap == null) return ResponseEntity.status(400).body(BaseResponseBody.of(400,"잘못된 요청"));
            return ResponseEntity.status(201).body(AppointmentGetRes.of(201, "Success", ap));
        } catch (EntityExistsException e) {
            return ResponseEntity.status(409).body(BaseResponseBody.of(409, "이미 존재하는 진료 아이디입니다."));
        }
    }

    @GetMapping("/info/list/{patientId}")
    @ApiOperation(value = "예약한 진료 리스트(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "진료 내역이 없습니다"),
            @ApiResponse(code = 403, message = "환자가 아닌 회원"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentList(@PathVariable String patientId) {
        List<AppointmentGetRes> list = appointmentService.getAppointments(patientId);
        if(list == null) return ResponseEntity.status(403).body(BaseResponseBody.of(403, "환자가 아닌 회원입니다."));
        if(list.size() > 0) return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
    }

    @GetMapping("/info/list/doctor/{doctorId}")
    @ApiOperation(value = "예약한 진료 리스트(의사)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 403, message = "의사가 아닌 회원"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorAppointmentList(@PathVariable String doctorId) {
        List<AppointmentGetRes> list = appointmentService.getDoctorAppointments(doctorId);
        if(list == null) return ResponseEntity.status(403).body(BaseResponseBody.of(403,"의사가 아닌 회원입니다."));
        if(list.size() > 0) return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
    }

    @GetMapping("/info/detail/{appointmentId}")
    @ApiOperation(value = "진료 상세 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentDetail(@PathVariable int appointmentId) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if(appointment == null)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200,"no data"));
        return ResponseEntity.status(200).body(AppointmentDetailGetRes.of(200,"Success",appointment));
    }


    /* TODO: 403 에러 처리 */
    @PatchMapping("/prescription/{appointmentId}")
    @ApiOperation(value = "처방 입력")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "진료 내역 없음"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 409, message = "처방이 이미 있음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> writePrescription(@PathVariable int appointmentId, @RequestBody PrescriptionPatchReq req) {
        //유저 로그인을 통해 토큰을 확인하는 과정과 그 유저가 의사가 맞는지를 확인하는 코드 필요
        Appointment ap = appointmentService.getAppointmentById(appointmentId);
        if(ap == null)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));

        if(ap.getPrescriptionDescription() != null)
            return ResponseEntity.status(409).body(BaseResponseBody.of(409,"처방 내역이 이미 있습니다."));

        appointmentService.writePrescription(appointmentId, req);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200,"Success"));
    }

    @GetMapping("/available-time/{doctorId}/{selectedDate}")
    @ApiOperation(value = "가능 시간")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 의사"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAvailableTimeList(@PathVariable String doctorId, @PathVariable String selectedDate) {
        try {
            User user = userService.getUserByUserId(doctorId);
            if (user.getDoctor() == null) {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200,"no data"));
        }


        AvailableTimeStore timeStore = new AvailableTimeStore();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime time = LocalDateTime.of(LocalDate.parse(selectedDate, formatter), LocalTime.of(0, 0));
        timeStore.init(time.toLocalDate());

        List<Appointment> appointmentList = appointmentService.findAvailableTime(doctorId, time);

        for (Appointment appointment : appointmentList) {
           timeStore.book(appointment.getAppointmentTime());
        }

        List<LocalDateTime> timeList = timeStore.getAvailableTimeList();

        return ResponseEntity.status(200).body(AvailableTimeGetRes.of(200, "Success", timeList));
    }


    @DeleteMapping("/cancel/{appointmentId}")
    @ApiOperation(value = "예약 취소")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> cancelAppointment(@ApiIgnore Authentication authentication,
                                               @ApiParam(value = "예약 번호", required = true)
                                               @PathVariable int appointmentId) {
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        if(user == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            Appointment appointment = appointmentService.findAppointmentByAppointmentId(appointmentId);
            appointmentService.deleteAppointment(appointment);
            if (!appointment.getUser().getUserId().equals(user.getUserId())) {
                return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }
}
