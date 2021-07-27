-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: localhost    Database: training
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `staffs`
--

DROP TABLE IF EXISTS `staffs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `staff_code` varchar(4) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name_romaji` varchar(20) NOT NULL,
  `first_name_romaji` varchar(20) NOT NULL,
  `staff_department` varchar(4) NOT NULL,
  `staff_attribute` varchar(4) DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `joined_year` varchar(10) NOT NULL,
  `carrer_type` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `staff_code_UNIQUE` (`staff_code`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffs`
--

LOCK TABLES `staffs` WRITE;
/*!40000 ALTER TABLE `staffs` DISABLE KEYS */;
INSERT INTO `staffs` VALUES (1,'0001','佐藤','春人','sato','haruto','0001','0001','案件概要','2000/01/01','0'),(2,'0002','鈴木','みお','suzuki','mio','0001','0002',NULL,'2000/04/01','1'),(3,'0003','高橋','颯太','takahashi','souta','0001','0002','案件概要','2005/04/01','0'),(4,'0004','田中','湊','tanaka','minato','0002','0003','','2005/04/01','0'),(5,'0005','伊藤','芽衣','ito','mei','0002','0001','案件概要','2000/01/01','0'),(6,'0006','渡辺','春樹','watanabe','haruki','0002','0001',NULL,'2010/08/01','1'),(7,'0007','山本','一香','yamamoto','ichika','0003','0004','案件概要','2010/08/10','0'),(8,'0008','中村','樹','nakamura','itsuki','0003','0003','案件概要','2015/10/12','1'),(9,'0009','小林','結衣','kobayashi','yui','0001','0004','案件概要','2016/01/01','1'),(10,'0010','加藤','葵','kato','aoi','0001','0002',NULL,'2020/04/01','0'),(11,'0011','吉田','明里','yoshida','akari','0003','0003',NULL,'2020/04/01','0'),(12,'0012','山田','華','yamada','hana','0002','0005',NULL,'2020/04/01','0');
/*!40000 ALTER TABLE `staffs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-27 22:04:46
