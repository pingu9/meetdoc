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
-- Table structure for table `doctor_medic_department`
--

DROP TABLE IF EXISTS `doctor_medic_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_medic_department` (
  `user_id` varchar(255) NOT NULL,
  `department_code` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`department_code`),
  KEY `FKn0gudloj7v3so4hpb3g76qopb` (`department_code`),
  CONSTRAINT `FKn0gudloj7v3so4hpb3g76qopb` FOREIGN KEY (`department_code`) REFERENCES `medic_department` (`department_code`),
  CONSTRAINT `FKpr29qvdaqww12qlo0fr5am6c9` FOREIGN KEY (`user_id`) REFERENCES `doctor` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_medic_department`
--

LOCK TABLES `doctor_medic_department` WRITE;
/*!40000 ALTER TABLE `doctor_medic_department` DISABLE KEYS */;
INSERT INTO `doctor_medic_department` VALUES ('meetdocDoctor',1),('user1',1),('user21',1),('user30',1),('user9',1),('user2',2),('user22',2),('user5',2),('user23',3),('user3',3),('user4',3),('user24',4),('user4',4),('user6',4),('user25',5),('user5',5),('user8',5),('usrDoctor',5),('user26',6),('user6',6),('user7',6),('user2',7),('user27',7),('user7',7),('user28',8),('user3',8),('user8',8),('user1',9),('user29',9),('user9',9);
/*!40000 ALTER TABLE `doctor_medic_department` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18  9:59:40
