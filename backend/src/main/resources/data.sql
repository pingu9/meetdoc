use meetdoc;

insert into medic_department (department_name, photo_url) values ('내과', 'stomache');
insert into medic_department (department_name, photo_url) values ('외과', 'surgery');
insert into medic_department (department_name, photo_url) values ('정신과', 'mental-health');
insert into medic_department (department_name, photo_url) values ('산부인과', 'pregnancy');
insert into medic_department (department_name, photo_url) values ('피부과', 'dermatology');
insert into medic_department (department_name, photo_url) values ('안과', 'eye');
insert into medic_department (department_name, photo_url) values ('이비인후과', 'ear');
insert into medic_department (department_name, photo_url) values ('소아청소년과', 'pediatric');
insert into medic_department (department_name, photo_url) values ('비뇨기과', 'urology');

insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user1', 'D', '김의사', 'male', '1984-02-05', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user2', 'D', '최의사', 'male', '1981-05-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user3', 'D', '박의사', 'male', '1970-03-03', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user4', 'D', '이의사', 'female', '1977-10-20', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user5', 'D', '황의사', 'male', '1977-09-20', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user6', 'D', '한의사', 'female', '1975-07-11', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user7', 'D', '신의사', 'male', '1979-06-25', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user8', 'D', '제갈의사', 'male', '1980-11-15', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user9', 'D', '권의사', 'female', '1977-04-18', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user10', 'D', '남궁의사', 'male', '1987-12-31', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user21', 'D', '진의사', 'male', '1986-01-31', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user22', 'D', '서의사', 'male', '1977-12-22', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user23', 'D', '홍의사', 'male', '1969-10-26', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user24', 'D', '우의사', 'male', '1972-07-29', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user25', 'D', '윤의사', 'male', '1978-08-31', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user26', 'D', '오의사', 'female', '1973-06-21', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user27', 'D', '송의사', 'male', '1983-03-15', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user28', 'D', '방의사', 'male', '1988-02-11', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user29', 'D', '강의사', 'female', '1981-11-02', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user30', 'D', '노의사', 'male', '1968-09-21', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user11', 'U', '김환자', 'female', '2000-05-15', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user12', 'U', '박환자', 'male', '1970-04-11', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user13', 'U', '이환자', 'female', '1987-05-31', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user14', 'U', '최환자', 'male', '1997-09-20', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user15', 'U', '신환자', 'male', '1994-01-26', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user16', 'U', '안환자', 'male', '1989-02-22', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user17', 'U', '황환자', 'male', '1996-02-29', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user18', 'U', '권환자', 'female', '1968-11-16', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user19', 'U', '홍환자', 'male', '1964-09-10', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user20', 'U', '서환자', 'male', '1965-12-01', 'active');

insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user1', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user2', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user3', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user4', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user5', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user6', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user7', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user8', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user9', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user10', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-4111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user11', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user12', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user13', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user14', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user15', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user16', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user17', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user18', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user19', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user20', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user21', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user22', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user23', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user24', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user25', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user26', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user27', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user28', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user29', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-2111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user30', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');

insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user1', '1111', 'hospital1', '010-0001-0001', '123-456', 'address', 'description', 50.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user2', '2222', 'hospital2', '010-0001-0002', '223-456', 'address', 'description', 52.5);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user3', '3333', 'hospital3', '010-0001-0003', '323-456', 'address', 'description', 60.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user4', '4444', 'hospital4', '010-0001-0004', '423-456', 'address', 'description', 45.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user5', '5555', 'hospital5', '010-0001-0005', '523-456', 'address', 'description', 55.5);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user6', '6666', 'hospital6', '010-0001-0006', '623-456', 'address', 'description', 50.25);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user7', '7777', 'hospital7', '010-0001-0007', '723-456', 'address', 'description', 70.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user8', '8888', 'hospital8', '010-0001-0008', '823-456', 'address', 'description', 57.5);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user9', '9999', 'hospital9', '010-0001-0009', '923-456', 'address', 'description', 35.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user10', '1234', 'hospital10', '010-0001-0010', '103-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user21', '2345', 'hospital11', '010-0001-0011', '113-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user22', '3456', 'hospital12', '010-0001-0012', '123-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user23', '4567', 'hospital13', '010-0001-0013', '133-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user24', '5678', 'hospital14', '010-0001-0014', '143-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user25', '6789', 'hospital15', '010-0001-0015', '153-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user26', '7890', 'hospital16', '010-0001-0016', '163-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user27', '1457', 'hospital17', '010-0001-0017', '173-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user28', '1122', 'hospital18', '010-0001-0018', '183-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user29', '2299', 'hospital19', '010-0001-0019', '213-456', 'address', 'description', 40.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user30', '3027', 'hospital20', '010-0001-0020', '203-456', 'address', 'description', 40.0);

INSERT INTO appointment (`appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-07 11:00', '52.5', '45', '2022-08-07', '처방 설명', 'FINISHED', '증상', 'user2', 'user11', '외과');
INSERT INTO appointment (`appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-07-29 09:00', '52.5', '45', '2022-08-07', '처방 설명', 'FINISHED', '증상', 'user2', 'user11', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-09 11:30', '52.5', '50', '2022-08-09', '처방 설명', 'FINISHED', '증상', 'user2', 'user12', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-07-30 11:30', '52.5', '50', '2022-08-09', '처방 설명', 'FINISHED', '증상', 'user2', 'user12', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-07-31 17:00', '52.5', '10', '2022-08-09', '처방 설명', 'FINISHED', '증상', 'user2', 'user13', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-09 15:00', '52.5', '10', '2022-08-09', '처방 설명', 'FINISHED', '증상', 'user2', 'user13', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-08 15:00', '52.5', '9', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user1', 'user14', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-08 16:00', '52.5', '7', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user1', 'user15', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-07-31 16:00', '52.5', '7', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user1', 'user15', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-09 14:00', '52.5', '5', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user1', 'user16', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-02 11:00', '52.5', '5', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user1', 'user16', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-08 11:00', '60.0', '15', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user3', 'user17', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-09 15:00', '60.0', '17', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user3', 'user18', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-02 15:00', '60.0', '17', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user3', 'user18', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-08 15:00', '60.0', '19', '2022-08-08', '처방 설명', 'FINISHED', '증상', 'user3', 'user19', '정신과');

INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 17:00', '52.5', 'OPEN', '증상', 'user2', 'user11', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 14:00', '52.5', 'PENDING_PRESCRIPTION', '증상', 'user2', 'user11', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 16:00', '52.5', 'WAITING', '증상', 'user2', 'user11', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 17:00', '52.5', 'CANCELED', '증상', 'user2', 'user12', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 10:00', '52.5', 'WAITING', '증상', 'user2', 'user13', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 11:00', '52.5', 'WAITING', '증상', 'user2', 'user11', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 14:00', '52.5', 'WAITING', '증상', 'user2', 'user13', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 17:30', '52.5', 'PENDING_CANCEL_DOCTOR', '증상', 'user2', 'user12', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 17:30', '52.5', 'FINISHED', '증상', 'user2', 'user12', '외과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 09:30', '52.5', 'PENDING_CANCEL_PATIENT', '증상', 'user2', 'user11', '외과');
-- INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 17:30', '52.5', 'WAITING', '증상', 'user2', 'user12', '외과');

INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 16:00', '50.5', 'PENDING_PRESCRIPTION', '증상', 'user1', 'user14', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 17:00', '50.5', 'WAITING', '증상', 'user1', 'user14', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 09:30', '50.5', 'PENDING_CANCEL_DOCTOR', '증상', 'user1', 'user14', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 14:30', '50.5', 'OPEN', '증상', 'user1', 'user15', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 17:30', '50.5', 'PENDING_CANCEL_PATIENT', '증상', 'user1', 'user15', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 09:30', '50.5', 'WAITING', '증상', 'user1', 'user15', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 14:00', '50.5', 'WAITING', '증상', 'user1', 'user16', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-16 17:30', '50.5', 'CANCELED', '증상', 'user1', 'user16', '내과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-17 14:30', '50.5', 'WAITING', '증상', 'user1', 'user16', '내과');

INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 16:00', '60', 'PENDING_PRESCRIPTION', '증상', 'user3', 'user17', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 17:00', '60', 'WAITING', '증상', 'user3', 'user17', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 09:30', '60', 'PENDING_CANCEL_DOCTOR', '증상', 'user3', 'user17', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 14:30', '60', 'OPEN', '증상', 'user3', 'user18', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 17:30', '60', 'PENDING_CANCEL_PATIENT', '증상', 'user3', 'user18', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 09:30', '60', 'WAITING', '증상', 'user3', 'user18', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 14:00', '60', 'WAITING', '증상', 'user3', 'user19', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-16 17:30', '62.25', 'CANCELED', '증상', 'user3', 'user19', '정신과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-17 14:30', '60', 'WAITING', '증상', 'user3', 'user19', '정신과');

INSERT INTO appointment ( `appointment_time`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-02 14:00', '60', '24', '2022-08-02', '피부 처방', 'FINISHED', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 16:00', '60', 'PENDING_PRESCRIPTION', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 14:30', '60', 'OPEN', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-12 17:00', '60', 'WAITING', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-15 09:30', '60', 'PENDING_CANCEL_DOCTOR', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-11 17:30', '60', 'PENDING_CANCEL_PATIENT', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-16 17:30', '62.25', 'CANCELED', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-17 14:30', '60', 'WAITING', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 09:30', '60', 'DOCTOR_ABSENT', '증상', 'user5', 'user20', '피부과');
INSERT INTO appointment ( `appointment_time`, `charge`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`, `department_name`) VALUES ('2022-08-10 10:30', '60', 'PATIENT_ABSENT', '증상', 'user5', 'user20', '피부과');

INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user1', '1');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user2', '2');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user3', '3');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user4', '4');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user5', '5');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user6', '6');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user7', '7');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user8', '8');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user9', '9');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user21', '1');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user22', '2');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user23', '3');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user24', '4');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user25', '5');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user26', '6');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user27', '7');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user28', '8');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user29', '9');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user30', '1');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user1', '9');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user2', '7');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user3', '8');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user4', '3');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user5', '2');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user6', '4');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user7', '6');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user8', '5');
INSERT INTO doctor_medic_department (`user_id`, `department_code`) VALUES ('user9', '1');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user1');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user1');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user1');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user1');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user1');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user2');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user2');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user2');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user2');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user2');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user3');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user3');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user3');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user3');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user3');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user4');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user4');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user4');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user4');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user4');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user5');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user5');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user5');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user5');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user5');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user6');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user6');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user6');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user6');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user6');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user7');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user7');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user7');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user7');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user7');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user8');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user8');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user8');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user8');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user8');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user9');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user9');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user9');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user9');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user9');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user10');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user10');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user10');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user10');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user10');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user21');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user21');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user21');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user21');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user21');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user22');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user22');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user22');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user22');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user22');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user23');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user23');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user23');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user23');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user23');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user24');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user24');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user24');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user24');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user24');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user25');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user25');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user25');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user25');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user25');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user26');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user26');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user26');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user26');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user26');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user27');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user27');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user27');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user27');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user27');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user28');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user28');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user28');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user28');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user28');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user29');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user29');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user29');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user29');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user29');

INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Mon', '12:00', '09:00', '2022-07-26', 'user30');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Tue', '12:00', '09:00', '2022-07-26', 'user30');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Wed', '12:00', '09:00', '2022-07-26', 'user30');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Thu', '12:00', '09:00', '2022-07-26', 'user30');
INSERT INTO opening_hours (`close`, `day_of_the_week`, `lunch_hour`, `open`, `start_date`, `user_id`) VALUES ('18:00', 'Fri', '12:00', '09:00', '2022-07-26', 'user30');
-- insert into medic_department (department_name) values ('신경과');
-- insert into medic_department (department_name) values ('정형외과');
-- insert into medic_department (department_name) values ('신경외과');
-- insert into medic_department (department_name) values ('흉부외과');
-- insert into medic_department (department_name) values ('성형외과');
-- insert into medic_department (department_name) values ('진단검사의학과');
-- insert into medic_department (department_name) values ('결핵과');
-- insert into medic_department (department_name) values ('재활의학과');
-- insert into medic_department (department_name) values ('가정의학과');
-- insert into medic_department (department_name) values ('핵의학과');
-- insert into medic_department (department_name) values ('마취통증의학과');
-- insert into medic_department (department_name) values ('방사선종양학과');
-- insert into medic_department (department_name) values ('병리과');
-- insert into medic_department (department_name) values ('예방의학과');
-- insert into medic_department (department_name) values ('응급의학과');
-- insert into medic_department (department_name) values ('산업의학과');
-- insert into medic_department (department_name) values ('치과');
-- insert into medic_department (department_name) values ('기타진료과');



-- insert into medic_department (department_name) values ('한방과')
-- insert into medic_department (department_name) values ('한방내과')
-- insert into medic_department (department_name) values ('한방소아과')
-- insert into medic_department (department_name) values ('한방신경정신과')
-- insert into medic_department (department_name) values ('한방안이비인후과')
-- insert into medic_department (department_name) values ('한방침구과')
-- insert into medic_department (department_name) values ('한방피부과')
-- insert into medic_department (department_name) values ('한방재활의학과')
-- insert into medic_department (department_name) values ('사상체질과')
-- insert into medic_department (department_name) values ('한방응급실')
-- insert into medic_department (department_name) values ('한방기타진료과')
