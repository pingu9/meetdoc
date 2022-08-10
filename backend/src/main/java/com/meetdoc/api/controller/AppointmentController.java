package com.meetdoc.api.controller;

import com.meetdoc.api.request.AppointmentPostReq;
import com.meetdoc.api.request.PrescriptionPatchReq;
import com.meetdoc.api.response.*;
import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.S3Service;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.auth.UserDetails;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.common.util.AvailableTimeStore;
import com.meetdoc.common.util.DateConverter;
import com.meetdoc.common.util.DayOffWeekMapper;
import com.meetdoc.db.entity.*;
import com.querydsl.core.NonUniqueResultException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
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
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 409, message = "중복 진료 내역"),
            @ApiResponse(code = 500, message = "서버 오류")
    })

    public ResponseEntity<?> reserveAppointment(@ApiIgnore Authentication authentication,
                                                @RequestBody AppointmentPostReq req) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String userId = userDetails.getUsername();

        if (!userId.equals(req.getPatientId())) {
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, "권한 에러."));
        }
        try {
            Appointment ap = appointmentService.createAppointment(req);
            if(ap == null) return ResponseEntity.status(400).body(BaseResponseBody.of(400,"잘못된 요청"));
            if(req.getSymptomImages() != null){
                List<String> fileName = req.getSymptomImages();
                List<SymptomImage> list = ap.getSymptomImages();
                fileName.forEach(name -> {
                    list.add(appointmentService.createSymptomImage(name, ap));
                });
            }
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
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 403, message = "환자가 아닌 회원"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentList(@ApiIgnore Authentication authentication,
                                                @PathVariable String patientId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String userId = userDetails.getUsername();

        if (!userId.equals(patientId)) {
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, "권한 에러."));
        }
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
            @ApiResponse(code = 401, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 403, message = "의사가 아닌 회원"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorAppointmentList(@ApiIgnore Authentication authentication,
                                                      @PathVariable String doctorId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String userId = userDetails.getUsername();

        if (!userId.equals(doctorId)) {
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, "권한 에러."));
        }

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
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 403, message = "로그인한 회원의 진료가 아님"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getAppointmentDetail(@ApiIgnore Authentication authentication, @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String userId = userDetails.getUsername();

        if (userId == null) {
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, "권한 에러."));
        }

        Appointment appointment = appointmentService.getAppointmentById(appointmentId);
        if(appointment == null)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200,"no data"));
        else if(appointment.getUser().getUserId().equals(userId) || appointment.getDoctor().getUserId().equals(userId))
            return ResponseEntity.status(200).body(AppointmentDetailGetRes.of(200,"Success",appointment));
        else return ResponseEntity.status(403).body(BaseResponseBody.of(403, "로그인한 회원의 진료가 아님"));
    }


    @PatchMapping("/prescription/{appointmentId}")
    @ApiOperation(value = "처방 입력")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "진료 내역 없음"),
            @ApiResponse(code = 401, message = "권한 없음"),
            @ApiResponse(code = 403, message = "의사가 아닌 회원"),
            @ApiResponse(code = 409, message = "처방이 이미 있음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> writePrescription(@ApiIgnore Authentication authentication,
                                               @PathVariable int appointmentId,
                                               @RequestBody PrescriptionPatchReq req) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String userId = userDetails.getUsername();

        Appointment ap;
        try {
            ap = appointmentService.getAppointmentById(appointmentId);
        } catch(EntityNotFoundException e) {
            return ResponseEntity.status(400).body(BaseResponseBody.of(400, "잘못된 요청"));
        }

        if (!userId.equals(ap.getUser().getUserId())) {
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, "권한 에러"));
        }
        User user = userService.getUserByUserId(userId);
        if (!user.getUserType().equals("D")) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(401, "의사가 아닌 회원입니다"));
        }

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
        User user;
        String userId;
        OpeningHours openingHour;
        LocalDateTime time = DateConverter.dateStringToLocalDateTime(selectedDate);
        String dayOfWeek = DayOffWeekMapper.DayOfWeekToString(time.getDayOfWeek());

        try {
            user = userService.getUserByUserId(doctorId);
            userId = user.getUserId();
            if (!userService.isDoctor(user)) {
                throw new Exception();
            }
        } catch (Exception e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200,"no data"));
        }

        if (userService.isDayOff(userId, time.toLocalDate())) {
            return ResponseEntity.status(200).body(AvailableTimeGetRes.of(200, "no data", new ArrayList<>()));
        }

        try {
            openingHour = userService.getOpeningHoursByIdAndWeekDay(user.getUserId(), dayOfWeek);
        } catch (NoSuchElementException e) {
            // 해당일에 근무하지 않을 경우
            return ResponseEntity.status(200).body(AvailableTimeGetRes.of(200, "no data", new ArrayList<>()));
        } catch (NonUniqueResultException e) {
            // 해당일 근무 정보가 여러개 들어있을 경우(서버 에러)
            return ResponseEntity.status(500).body(AvailableTimeGetRes.of(500, "서버 에러 발생"));
        }

        List<LocalDateTime> timeList = appointmentService.getAvailableTimeList(doctorId, time, openingHour);

        return ResponseEntity.status(200).body(AvailableTimeGetRes.of(200, "Success", timeList));
    }


    @PatchMapping("/cancel/patient/{appointmentId}")
    @ApiOperation(value = "예약 취소(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 400, message = "상태에 안맞는 요청"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> cancelAppointmentByPatient(@ApiIgnore Authentication authentication,
                                               @ApiParam(value = "예약 번호", required = true)
                                               @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        if(user == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            Appointment appointment = appointmentService.findAppointmentByAppointmentId(appointmentId);
            if (!appointment.getUser().getUserId().equals(user.getUserId()))
                return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
            if(!appointment.getStatus().equals("WAITING"))
                return ResponseEntity.status(400).body(BaseResponseBody.of(400, "Bad Request"));
            appointmentService.changeStatus(appointment, "PENDING_CANCEL_PATIENT");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PatchMapping("/approve/doctor/{appointmentId}")
    @ApiOperation(value = "예약 취소 확인(의사)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 400, message = "상태에 안맞는 요청"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> cancelApproveByDoctor(@ApiIgnore Authentication authentication,
                                                        @ApiParam(value = "예약 번호", required = true)
                                                        @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        if(user == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            Appointment appointment = appointmentService.findAppointmentByAppointmentId(appointmentId);
            if (!appointment.getDoctor().getUserId().equals(user.getUserId()))
                return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
            if(!appointment.getStatus().equals("PENDING_CANCEL_PATIENT"))
                return ResponseEntity.status(400).body(BaseResponseBody.of(400, "Bad Request"));
            appointmentService.changeStatus(appointment, "CANCELED");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PatchMapping("/cancel/doctor/{appointmentId}")
    @ApiOperation(value = "예약 취소(의사)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 400, message = "상태에 안맞는 요청"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> cancelAppointmentByDoctor(@ApiIgnore Authentication authentication,
                                                        @ApiParam(value = "예약 번호", required = true)
                                                        @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        if(user == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            Appointment appointment = appointmentService.findAppointmentByAppointmentId(appointmentId);
            if (!appointment.getDoctor().getUserId().equals(user.getUserId()))
                return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
            if(!appointment.getStatus().equals("WAITING"))
                return ResponseEntity.status(400).body(BaseResponseBody.of(400, "Bad Request"));
            appointmentService.changeStatus(appointment, "PENDING_CANCEL_DOCTOR");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PatchMapping("/approve/patient/{appointmentId}")
    @ApiOperation(value = "예약 취소 확인(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 400, message = "상태에 안맞는 요청"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> cancelApproveByPatient(@ApiIgnore Authentication authentication,
                                                   @ApiParam(value = "예약 번호", required = true)
                                                   @PathVariable int appointmentId) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        if(user == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }

        try {
            Appointment appointment = appointmentService.findAppointmentByAppointmentId(appointmentId);
            if (!appointment.getUser().getUserId().equals(user.getUserId()))
                return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
            if(!appointment.getStatus().equals("PENDING_CANCEL_DOCTOR"))
                return ResponseEntity.status(400).body(BaseResponseBody.of(400, "Bad Request"));
            appointmentService.changeStatus(appointment, "CANCELED");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        }
        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @GetMapping("/next")
    @ApiOperation(value = "예약 취소 확인(환자)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 진료 내역"),
            @ApiResponse(code = 401, message = "토큰 없음"),
            @ApiResponse(code = 403, message = "권한이 없는 요청"),
    })
    public ResponseEntity<?> getNextAppointment(@ApiIgnore Authentication authentication) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String getUserId = userDetails.getUsername();
        User user = userService.getUserByUserId(getUserId);
        if(user == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "권한이 없는 요청입니다"));
        }
        List<Appointment> appointments = (List<Appointment>) user.getAppointments();
        if(appointments == null) return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        Appointment next = appointmentService.getNextAppointment(appointments);
        if(next == null) return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        return ResponseEntity.status(200).body(NextAppointmentRes.of(200, "Success", next));
    }
}
