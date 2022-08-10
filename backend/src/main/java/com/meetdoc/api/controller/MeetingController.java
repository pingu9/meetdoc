package com.meetdoc.api.controller;

import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.MeetingService;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.auth.UserDetails;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Appointment;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 화상회의 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "화상회의 API", tags = {"Meeting"})
@RestController
@RequestMapping("/meeting")
public class MeetingController {
    @Autowired
    UserService userService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    MeetingService meetingService;

    @PatchMapping("/enter/doctor/{appointmentId}")
    @ApiOperation(value = "진료실 입장 로그(의사)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "중복 입장"),
            @ApiResponse(code = 401, message = "토큰 없음"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> enterMeetingRoomDoctorLog(@ApiIgnore Authentication authentication,
                                                       @ApiParam(value = "예약 번호", required = true)
                                                       @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        Appointment appointment;

        if(!userService.isDoctor(user)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            appointment = appointmentService.getAppointmentById(appointmentId);
        } catch (Exception e) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        if (!meetingService.isDoctorBelongsToMeeting(appointment, getUserId)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        if (meetingService.isThereDoctorEnterLog(appointment)) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "이미 입장하였습니다"));
        }
        if (!appointmentService.isOpen(appointment)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        meetingService.enterMeetingRoomDoctorLog(appointment);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PatchMapping("/leave/doctor/{appointmentId}")
    @ApiOperation(value = "진료실 퇴장 로그(의사)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "토큰 없음"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> leaveMeetingRoomDoctorLog(@ApiIgnore Authentication authentication,
                                                       @ApiParam(value = "예약 번호", required = true)
                                                       @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        Appointment appointment;

        if (!userService.isDoctor(user)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            appointment = appointmentService.getAppointmentById(appointmentId);
        } catch (Exception e) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        if (!meetingService.isDoctorBelongsToMeeting(appointment, getUserId)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        meetingService.leaveMeetingRoomDoctorLog(appointment);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PatchMapping("/enter/patient/{appointmentId}")
    @ApiOperation(value = "진료실 입장 로그(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "중복 입장"),
            @ApiResponse(code = 401, message = "토큰 없음"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> enterMeetingRoomPatientLog(@ApiIgnore Authentication authentication,
                                                       @ApiParam(value = "예약 번호", required = true)
                                                       @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);

        if (!userService.isPatient(user)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        Appointment appointment;
        try {
            appointment = appointmentService.getAppointmentById(appointmentId);
        } catch (Exception e) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        if (!meetingService.isPatientBelongsToMeeting(appointment, getUserId)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        if (meetingService.isTherePatientEnterLog(appointment)) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "이미 입장하였습니다"));
        }
        if (!appointmentService.isOpen(appointment)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        meetingService.enterMeetingRoomPatientLog(appointment);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PatchMapping("/leave/patient/{appointmentId}")
    @ApiOperation(value = "진료실 퇴장 로그(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "토큰 없음"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> leaveMeetingRoomPatientLog(@ApiIgnore Authentication authentication,
                                                       @ApiParam(value = "예약 번호", required = true)
                                                       @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        Appointment appointment;

        if (!userService.isPatient(user)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            appointment = appointmentService.getAppointmentById(appointmentId);
        } catch (Exception e) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        if (!meetingService.isPatientBelongsToMeeting(appointment, getUserId)) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        meetingService.leaveMeetingRoomPatientLog(appointment);
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    /*
    로그 관련 정책 정리

    1. 입장 : 입장 로그는 최초 1회만 찍힘 -> 만약 로그가 이미 찍혀있다면 찍으면 안됨 -> success를 보내도 되고, 코드는 크게 중요하지 않음
    2. 퇴장 : 퇴장 로그는 가장 마지막에 퇴장한 것 기준으로 로그가 찍힘 -> 확인 없이 바로 업데이트 해도됨

    토큰 확인 필요, 유저 본인 맞는지, 의사 환자 각자 맞는지 확인하기

    각 로그 찍는 부분은 JoinSession 하단에서 Session 입장 이후 api 호출 바로 하시면 됩니다.
    퇴장은 leaveSession에서 초기화 하는 부분에 호출해주시면 됩니다.
     */
}
