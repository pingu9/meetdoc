use meetdoc;

insert into medic_department (department_name) values ('내과');
insert into medic_department (department_name) values ('외과');
insert into medic_department (department_name) values ('정신과');
insert into medic_department (department_name) values ('산부인과');
insert into medic_department (department_name) values ('피부과');
insert into medic_department (department_name) values ('안과');
insert into medic_department (department_name) values ('이비인후과');
insert into medic_department (department_name) values ('소아청소년과');
insert into medic_department (department_name) values ('비뇨기과');

insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user1', 'D', 'doctor1', 'male', '2000-01-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user2', 'D', 'doctor2', 'male', '2000-01-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user3', 'D', 'deleted_doctor', 'male', '2000-01-01', 'deleted');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user4', 'D', 'pending_doctor', 'male', '2000-01-01', 'pending');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user5', 'U', 'user1', 'male', '2000-01-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user6', 'U', 'user2', 'male', '2000-01-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user7', 'U', 'user3', 'male', '2000-01-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user8', 'U', 'user4', 'male', '2000-01-01', 'active');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user9', 'U', 'pending_user', 'male', '2000-01-01', 'pending');
insert into `user` (`user_id`, `user_type`, `name`, `gender`, `birthdate`, `status`) values ('user10', 'U', 'inactive_user', 'male', '2000-01-01', 'deleted');

insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user1', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user2', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user3', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user4', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user5', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user6', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user7', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user8', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user9', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');
insert into user_info (`user_id`, `password`, `rrn`, `zipcode`, `address`, `phone`, `email`) values ('user10', '$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u', '111111-1111111', '111-111', 'address', '010-0000-0000', 'aaa@aaa.com');

insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user1', '1111', 'hospital1', '010-0001-0001', '123-456', 'address', 'description', 10000.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user2', '2222', 'hospital2', '010-0001-0001', '123-456', 'address', 'description', 10000.0);
insert into doctor (`user_id`, `license_number`, `hospital_name`, `hospital_phone`, `hospital_zipcode`, `hospital_address`, `hospital_description`, `charge`) values ('user3', '3333', 'hospital3', '010-0001-0001', '123-456', 'address', 'description', 10000.0);

INSERT INTO `meetdoc`.`doctor_medic_department` (`user_id`, `department_code`) VALUES ('user1', '1');
INSERT INTO `meetdoc`.`doctor_medic_department` (`user_id`, `department_code`) VALUES ('user2', '2');
INSERT INTO `meetdoc`.`doctor_medic_department` (`user_id`, `department_code`) VALUES ('user3', '3');
INSERT INTO `meetdoc`.`doctor_medic_department` (`user_id`, `department_code`) VALUES ('user3', '4');

INSERT INTO appointment (`appointment_id`, `appointment_date`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`) VALUES ('1', '2022-07-26 11:00', '5000', '45', '2022-07-26', '처방 설명', 'B', '증상', 'user3', 'user8');
INSERT INTO appointment (`appointment_id`, `appointment_date`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`) VALUES ('2', '2022-07-26 15:30', '6000', '50', '2022-07-26', '처방 설명', 'A', '증상', 'user2', 'user9');
INSERT INTO appointment (`appointment_id`, `appointment_date`, `charge`, `icd`, `prescription_date`, `prescription_description`, `status`, `symptom`, `doctor_user_id`, `patient_user_id`) VALUES ('3', '2022-07-26 09:30', '103.25', '10', '2022-07-26', '처방 설명', 'A', '증상', 'user1', 'user7');

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