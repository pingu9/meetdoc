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
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `user_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `rrn` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `FKn8pl63y4abe7n0ls6topbqjh2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES ('meetdocDoctor','서울시 강남구 역삼동','ssafyDoctor@meetdoc.com','$2a$10$MINzJ1hR0yboT879.wcAxuCHu1LrRgJ2sTVaGRu.hxC88WKlN86XO','010-0000-0000','111111-1111111','111-111'),('meetdocPatient','서울시 강남구 역삼동','ssafyPatient@meetdoc.com','$2a$10$MINzJ1hR0yboT879.wcAxuCHu1LrRgJ2sTVaGRu.hxC88WKlN86XO','010-0000-0000','111111-1111111','111-111'),('user1','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user10','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-4111111','111-111'),('user11','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user12','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user13','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user14','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user15','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user16','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user17','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user18','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user19','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user2','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user20','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user21','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user22','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user23','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user24','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user25','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user26','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user27','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user28','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user29','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user3','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user30','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user4','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user5','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user6','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user7','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('user8','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-2111111','111-111'),('user9','address','aaa@aaa.com','$2a$10$3CKr/PF9Ng2jE2qcQeK0jOIJHP28cECPL298pBDWjyYGdJYfkQx2u','010-0000-0000','111111-1111111','111-111'),('usrDoctor','address','usrDoctor@meetdoc.com','$2a$10$MINzJ1hR0yboT879.wcAxuCHu1LrRgJ2sTVaGRu.hxC88WKlN86XO','010-0000-0000','111111-1111111','111-111'),('usrPatient','address','usrPatient@meetdoc.com','$2a$10$MINzJ1hR0yboT879.wcAxuCHu1LrRgJ2sTVaGRu.hxC88WKlN86XO','010-0000-0000','111111-1111111','111-111');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18  9:59:41
