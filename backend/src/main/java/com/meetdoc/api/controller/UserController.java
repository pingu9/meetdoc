package com.meetdoc.api.controller;

import com.meetdoc.api.request.DoctorPostReq;
import com.meetdoc.api.request.UserLoginPostReq;
import com.meetdoc.api.request.UserPostReq;
import com.meetdoc.api.response.UserLoginPostRes;
import com.meetdoc.api.service.UserService;
import com.meetdoc.common.model.response.BaseResponseBody;
import com.meetdoc.common.util.JwtTokenUtil;
import com.meetdoc.db.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;

@Api(value = "유저 API", tags = {"User"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    /* TODO */
    /* password verification, null check 필요 */
    @PostMapping
    @ApiOperation(value = "회원 가입", notes = "비밀번호, 항목 유효성 검사 후 회원 가입을 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "필수항목 공백, 비밀번호 조건건"),            @ApiResponse(code = 407, message = "이미 존재하는 아이디"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody @ApiParam(value = "회원가입", required = true) UserPostReq registerInfo) {
        try {
            userService.createUser(registerInfo);
        } catch(EntityExistsException e) {
            return ResponseEntity.status(407).body(BaseResponseBody.of(406, "이미 존재하는 아이디입니다."));
        }

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "회원 로그인")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "필수항목 공백 또는 다수 시도"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> login(
            @RequestBody @ApiParam(value = "로그인", required = true) UserLoginPostReq loginInfo) {

        String userId = loginInfo.getUserId();
        String password = loginInfo.getPassword();

        User user;
        try {
            user = userService.getUserByUserId(userId);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(UserLoginPostRes.of(406, "존재하지 않는 회원입니다.", null));
        }

        // 로그인 요청한 유저로부터 입력된 패스워드 와 디비에 저장된 유저의 암호화된 패스워드가 같은지 확인.(유효한 패스워드인지 여부 확인)
        if(passwordEncoder.matches(password, user.getUserInfo().getPassword())) {
            // 유효한 패스워드가 맞는 경우, 로그인 성공으로 응답.(액세스 토큰을 포함하여 응답값 전달)
            return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(userId)));
        }
        // 유효하지 않는 패스워드인 경우, 로그인 실패로 응답.
        return ResponseEntity.status(401).body(UserLoginPostRes.of(406, "비밀번호가 틀렸습니다.", null));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "아이디 중복 체크", notes = "해당 아이디가 존재하는지 체크한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 406, message = "중복 아이디"),
            @ApiResponse(code = 500, message = "서버 문제로 인한 에러"),
    })

    public ResponseEntity<? extends BaseResponseBody> duplicateIdCheck(
            @PathVariable String userId) {
        try {
            userService.getUserByUserId(userId);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "사용 가능한 ID입니다."));
        }
        return ResponseEntity.status(406).body(BaseResponseBody.of(406, "이미 존재하는 사용자 ID입니다."));
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
    @ApiOperation(value = "회원 상세 정보", notes = "회원 상세 정보")
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
