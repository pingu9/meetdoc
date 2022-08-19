# MeetDoc

![logo](frontend/public/favicon.png)

## 프로젝트 소개
의료 사각 지대, 만성 질환자, 응급 환자를 위한 비대면 진료 서비스 MeetDoc (믿닥) 입니다.

## 팀 소개
- 우시은 : BE, 팀장
- 권덕주 : BE
- 안현모 : FE
- 이나현 : FE
- 황준원 : BE

## 프로젝트 상세 설명

### 시스템 아키텍쳐

![MeetDocArchitecture](exec/Image/MeetDoc%20Architecture.png)

### 진료 Status

![Status](exec/Image/Status%20Graph.jpg)

- 진료 중 : OPEN
- 진료 대기 : WAITING
- 처방전 작성 대기 : PENDING_PRESCRIPTION
- 환자 취소 대기 : PENDING_CANCEL_PATIENT
- 의사 취소 대기 : PENDING_CANCEL_DOCTOR
- 진료 완료 : FINISHED
- 진료실 미접속
    - 의사 미접속 상태로 종료 : DOCTOR_ABSENT
    - 환자 미접속 상태로 종료 : PATIENT_ABSENT
- 취소 완료 : CANCELED

### 시연 시나리오

[시연 시나리오](exec/%EC%8B%9C%EC%97%B0%20%EC%8B%9C%EB%82%98%EB%A6%AC%EC%98%A4.md)

### 배포 가이드

[배포 가이드](exec/%EB%B0%B0%ED%8F%AC%20%EA%B0%80%EC%9D%B4%EB%93%9C.md)