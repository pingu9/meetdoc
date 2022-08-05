package com.meetdoc.api.controller;

import com.meetdoc.api.service.S3Service;
import com.meetdoc.common.model.response.BaseResponseBody;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/s3")
public class S3Controller {

    @Autowired
    S3Service s3Service;

    @PostMapping("/upload/image")
    @ApiOperation(value = "사진 1개 등록")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> uploadImage(@ApiIgnore Authentication authentication, @RequestPart MultipartFile image) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        String photoUrl = s3Service.uploadFile(image);
        return ResponseEntity.ok().body(photoUrl);
    }
    @PostMapping("/upload/images")
    @ApiOperation(value = "사진 여러개 등록")
    @ApiResponses({
            @ApiResponse(code = 201, message = "성공"),
            @ApiResponse(code = 401, message = "권한 에러"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<?> uploadImages(@ApiIgnore Authentication authentication, @RequestPart List<MultipartFile> images) {
        if(authentication == null) return ResponseEntity.status(401).body(BaseResponseBody.of(401, "토큰 없음."));
        List<String> photoUrl = s3Service.uploadFile(images);
        return ResponseEntity.ok().body(photoUrl);
    }
}
