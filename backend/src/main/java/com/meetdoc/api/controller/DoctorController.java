package com.meetdoc.api.controller;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.api.request.OpeningHourPostReq;
import com.meetdoc.api.response.DoctorDetailGetRes;
import com.meetdoc.api.response.DoctorListGetRes;
import com.meetdoc.api.service.AppointmentService;
import com.meetdoc.api.service.DoctorService;
import com.meetdoc.api.service.S3Service;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.auth.UserDetails;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.Doctor;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.EntityNotFoundException;
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
    @Autowired
    S3Service s3Service;

    @PostMapping("/regist")
    @ApiOperation(value = "의사 회원가입", notes = "의사 회원의 경우 필요한 항목들을 추가 입력한다.")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })
    public ResponseEntity<? extends BaseResponseBody> doctorRegister(
            @RequestPart @ApiParam(value = "registerInfo", required = true) DoctorPostReq registerInfo
            , @RequestPart(required = false) MultipartFile image) {
        if(image != null) {
            String fileName = s3Service.uploadFile(image);
            registerInfo.setPhotoUrl(fileName);
        }
        doctorService.createDoctor(registerInfo);

        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }

    @PostMapping("/opening-hours")
    @ApiOperation(value = "의사 진료 가능 시간 등록")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code= 403, message = "의사가 아닌 회원"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })
    public  ResponseEntity<? extends  BaseResponseBody> setOpeningHours(@ApiIgnore Authentication authentication,
                                                                        @RequestBody OpeningHourPostReq req) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        UserDetails userDetails = (UserDetails)authentication.getDetails();
        String userId = userDetails.getUsername();
        if (!userId.equals(req.getDoctorId())) {
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, "권한 에러."));
        }
        try {
            doctorService.setOpeningHours(req.getDoctorId(),req.getOpeningHours());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "의사 회원이 아닙니다."));
        }

        return ResponseEntity.status(201).body(BaseResponseBody.of(201, "Success"));
    }

    @GetMapping("/detail/{doctorId}")
    @ApiOperation(value = "의사 상세 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 200, message = "존재하지 않는 아이디"),
            @ApiResponse(code = 403, message = "의사 회원이 아닙니다."),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorDetail(@PathVariable  String doctorId) {
        User user = userService.getUserByUserId(doctorId);
        if(user == null)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "no data"));
        Doctor doctor = user.getDoctor();
        if (doctor == null) {
            return ResponseEntity.status(403).body(BaseResponseBody.of(403, "의사 회원이 아닙니다."));
        } else return ResponseEntity.status(200).body(DoctorDetailGetRes.of(200,"Success",doctor));
    }

    @GetMapping("/list/{departmentCode}")
    @ApiOperation(value = "페이지 숫자, 검색 쿼리를 적용한 ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> getDoctorList(@PathVariable int departmentCode, Pageable pageable, String doctorName) {
        List<Doctor> doctorList = appointmentService.searchDoctors(departmentCode, doctorName, pageable);
        String departmentName = appointmentService.getDepartmentNameById(departmentCode);

        return ResponseEntity.status(200).body(DoctorListGetRes.of(200,"Success", departmentName, doctorList));
    }
}
