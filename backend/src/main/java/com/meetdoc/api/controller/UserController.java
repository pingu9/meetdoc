package com.meetdoc.api.controller;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.api.service.UserService;
import com.meetdoc.api.service.UserServiceImpl;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    @ApiOperation(value = "회원 가입", notes = "비밀번호, 항목 유효성 검사 후 회원 가입을 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "필수항목 공백 또는 비밀번호 조건"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody @ApiParam(value = "회원가입", required = true) UserPostReq registerInfo) {
        int code = 0; //dummy

        if (code == 0) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        }
        else if (code == 1) {
            String errMsg = "항목에 공백이 있으면 안됩니다. 또한 비밀번호는 8자~15자 이며 영문 대소문자, 특수문자, 숫자를 사용해야 합니다.";
            return ResponseEntity.status(406).body(BaseResponseBody.of(406, errMsg));
        }
        else {
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "서버 에러 발생"));
        }
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "아이디 중복 체크", notes = "해당 아이디가 존재하는지 체크한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 409, message = "아이디 중복."),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> duplicateIdCheck(
            @PathVariable String userId) {
        try {
            User user = userService.getUserByUserId(userId);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "사용 가능한 아이디입니다."));
        }
        return ResponseEntity.status(409).body(BaseResponseBody.of(409, "이미 존재하는 아이디입니다."));
    }

    @PostMapping("/doctor")
    @ApiOperation(value = "의사 회원가입", notes = "의사 회원의 경우 필요한 항목들을 추가 입력한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> doctorRegister(
            @RequestBody @ApiParam(value = "회원가입", required = true) DoctorPostReq registerInfo) {
        int code = 0; //dummy

        if (code == 0) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        }
        else if (code == 1) {
            String errMsg = "올바르지 않은 입력입니다.";
            return ResponseEntity.status(406).body(BaseResponseBody.of(406, errMsg));
        }
        else {
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "서버 에러 발생"));
        }
    }

    @PatchMapping
    @ApiOperation(value = "회원정보 수정", notes = "회원 정보 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> updateUser(
            @RequestBody @ApiParam(value = "회원가입", required = true) DoctorPostReq registerInfo) {
        int code = 0; //dummy

        if (code == 0) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        }
        else if (code == 1) {
            String errMsg = "올바르지 않은 입력입니다.";
            return ResponseEntity.status(406).body(BaseResponseBody.of(406, errMsg));
        }
        else if (code == 2) {
            String errMsg = "권한이 없습니다.";
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, errMsg));
        }
        else {
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "서버 에러 발생"));
        }
    }


    @DeleteMapping("/{userId}")
    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> deleteUser(
            @PathVariable String userId) {
        int code = 0; //dummy

        if (code == 0) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        }
        else if (code == 1) {
            String errMsg = "올바르지 않은 입력입니다.";
            return ResponseEntity.status(406).body(BaseResponseBody.of(406, errMsg));
        }
        else if (code == 2) {
            String errMsg = "권한이 없습니다.";
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, errMsg));
        }
        else {
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "서버 에러 발생"));
        }
    }


    @GetMapping("/info/{userId}")
    @ApiOperation(value = "회원 탈퇴", notes = "회원 탈퇴")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 406, message = "입력 형식 에러"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> getUserInfo(
            @PathVariable String userId) {
        int code = 0; //dummy

        if (code == 0) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        }
        else if (code == 1) {
            String errMsg = "올바르지 않은 입력입니다.";
            return ResponseEntity.status(406).body(BaseResponseBody.of(406, errMsg));
        }
        else if (code == 2) {
            String errMsg = "권한이 없습니다.";
            return ResponseEntity.status(401).body(BaseResponseBody.of(401, errMsg));
        }
        else {
            return ResponseEntity.status(500).body(BaseResponseBody.of(500, "서버 에러 발생"));
        }
    }

}
