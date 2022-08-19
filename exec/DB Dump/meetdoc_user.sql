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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('meetdocDoctor','1962-12-01','male','강싸피','active','D'),('meetdocPatient','1997-12-01','male','최이조','active','U'),('user1','1984-02-05','male','김의사','active','D'),('user10','1987-12-31','male','남궁의사','active','D'),('user11','2000-05-15','female','김환자','active','U'),('user12','1970-04-11','male','박환자','active','U'),('user13','1987-05-31','female','이환자','active','U'),('user14','1997-09-20','male','최환자','active','U'),('user15','1994-01-26','male','신환자','active','U'),('user16','1989-02-22','male','안환자','active','U'),('user17','1996-02-29','male','황환자','active','U'),('user18','1968-11-16','female','권환자','active','U'),('user19','1964-09-10','male','홍환자','active','U'),('user2','1981-05-01','male','최의사','active','D'),('user20','1965-12-01','male','서환자','active','U'),('user21','1986-01-31','male','진의사','active','D'),('user22','1977-12-22','male','서의사','active','D'),('user23','1969-10-26','male','홍의사','active','D'),('user24','1972-07-29','male','우의사','active','D'),('user25','1978-08-31','male','윤의사','active','D'),('user26','1973-06-21','female','오의사','active','D'),('user27','1983-03-15','male','송의사','active','D'),('user28','1988-02-11','male','방의사','active','D'),('user29','1981-11-02','female','강의사','active','D'),('user3','1970-03-03','male','박의사','active','D'),('user30','1968-09-21','male','노의사','active','D'),('user4','1977-10-20','female','이의사','active','D'),('user5','1977-09-20','male','황의사','active','D'),('user6','1975-07-11','female','한의사','active','D'),('user7','1979-06-25','male','신의사','active','D'),('user8','1980-11-15','male','제갈의사','active','D'),('user9','1977-04-18','female','권의사','active','D'),('usrDoctor','2000-12-01','male','테스트의사','active','D'),('usrPatient','2000-12-01','male','테스트환자','active','U');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
