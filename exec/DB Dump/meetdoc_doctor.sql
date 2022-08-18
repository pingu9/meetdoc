-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: i7a302.p.ssafy.io    Database: meetdoc
-- ------------------------------------------------------
-- Server version	5.7.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `user_id` varchar(255) NOT NULL,
  `charge` decimal(19,2) DEFAULT NULL,
  `hospital_address` varchar(255) DEFAULT NULL,
  `hospital_description` varchar(255) DEFAULT NULL,
  `hospital_name` varchar(255) DEFAULT NULL,
  `hospital_phone` varchar(255) DEFAULT NULL,
  `hospital_zipcode` varchar(255) DEFAULT NULL,
  `license_number` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FK9roto9ydtnjfkixvexq5vxyl5` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('meetdocDoctor',0.00,'서울 강남구 역삼동 싸피병원','역삼동에 위치한 종합병원','싸피병원','010-0001-0025','123-456','3027','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/confident-doctor-looking-at-camera-holding-the-tablet-pc.jpg'),('user1',0.00,'address','description','역삼병원','010-0001-0001','123-456','1111','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/portrait-of-asian-doctor-woman-cross-arms-standing-in-medical-uniform-and-stethoscope-smiling-at-cam.jpg'),('user10',0.00,'address','description','성수병원','010-0001-0010','103-456','1234','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user2',0.00,'address','description','선릉병원','010-0001-0002','223-456','2222','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user21',0.00,'address','description','삼성병원','010-0001-0011','113-456','2345','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/smiling-asian-male-doctor-pointing-upwards.jpg'),('user22',0.00,'address','description','구의병원','010-0001-0012','123-456','3456','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user23',0.00,'address','description','강변병원','010-0001-0013','133-456','4567','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user24',0.00,'address','description','마장병원','010-0001-0014','143-456','5678','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user25',0.00,'address','description','금호병원','010-0001-0015','153-456','6789','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/smiling-young-female-doctor-raising-forefinger.jpg'),('user26',0.00,'address','description','강남병원','010-0001-0016','163-456','7890','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user27',0.00,'address','description','시청병원','010-0001-0017','173-456','1457','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user28',0.00,'address','description','양재병원','010-0001-0018','183-456','1122','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user29',0.00,'address','description','양평병원','010-0001-0019','213-456','2299','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user3',0.00,'address','description','서초병원','010-0001-0003','323-456','3333','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user30',0.00,'address','description','구로병원','010-0001-0020','203-456','3027','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/young-medical-intern-filling-out-report-papers.jpg'),('user4',0.00,'address','description','방배병원','010-0001-0004','423-456','4444','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user5',0.00,'address','description','사당병원','010-0001-0005','523-456','5555','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/confident-young-asian-female-doctor-in-white-medical-uniform-with-stethoscope.jpg'),('user6',0.00,'address','description','봉천병원','010-0001-0006','623-456','6666','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user7',0.00,'address','description','신림병원','010-0001-0007','723-456','7777','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/414.jpg'),('user8',0.00,'address','description','당산병원','010-0001-0008','823-456','8888','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/confident-beautiful-young-asian-female-doctor.jpg'),('user9',0.00,'address','description','합정병원','010-0001-0009','923-456','9999','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/young-asia-male-doctor-in-white-medical-uniform-with-stethoscope-using-computer-laptop-talk-video-conference-call-with-patient-looking-at-camera-in-health-hospital.jpg'),('usrDoctor',0.00,'서울 강남구 역삼동 싸피병원','description','싸피병원','010-0001-0026','203-461','3027','https://meet-doctor.s3.ap-northeast-2.amazonaws.com/confident-doctor-looking-at-camera-holding-the-tablet-pc.jpg');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18  9:59:39
