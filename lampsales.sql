-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: lampsales
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `lamp`
--

DROP TABLE IF EXISTS `lamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lamp` (
  `lamp_id` int NOT NULL AUTO_INCREMENT,
  `lamp_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lamp_brand` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lamp_power` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lamp_price` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lamp_Inventory` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`lamp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lamp`
--

LOCK TABLES `lamp` WRITE;
/*!40000 ALTER TABLE `lamp` DISABLE KEYS */;
INSERT INTO `lamp` VALUES (1,'美式台灯','法华仕','5w及以下','32','99'),(2,'中式台灯','中国制造','5w及以下','66','99'),(3,'中式台灯2','中国制造','5w及以下','55','88'),(4,'大吊灯','小厂','5w及以下','888','99'),(5,'卧室灯','大厂','5w及以下','33','99'),(6,'小台灯','中厂','5w及以下','22','99'),(7,'宿舍专用灯','民间作坊','5w及以下','11',' 99');
/*!40000 ALTER TABLE `lamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `lamp_id` int NOT NULL,
  `buy_count` int DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `total_money` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `user_id` (`user_id`),
  KEY `lamp_id` (`lamp_id`),
  CONSTRAINT `lamp_id` FOREIGN KEY (`lamp_id`) REFERENCES `lamp` (`lamp_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,1,1,3,'龙亭路8号','100'),(7,1,1,4,'龙亭路8号','128'),(8,1,1,2,'龙亭路8号','64'),(9,1,3,2,'龙亭路8号','110'),(10,1,1,4,'龙亭路8号','128'),(11,1,1,3,'龙亭路8号','96'),(12,1,1,2,'龙亭路8号','64'),(13,1,1,2,'龙亭路8号','64'),(14,1,1,99,'龙亭路8号','3168'),(15,1,5,3,'龙亭路8号','99'),(16,1,2,3,'龙亭路8号','96'),(17,1,1,12,'龙亭路8号','384');
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_phone` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_password` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `user_adress` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'叶子','18377451477','123456','龙亭路8号'),(2,'小智','18377451411','123456','广西南宁'),(3,'小叶子','18377451422','123456','南宁学院6栋508室'),(5,'Lotlyz','18377451122','123456','广西梧州'),(6,'侧耳倾听','18377450830','123456','广西岑溪');
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

-- Dump completed on 2022-07-07 21:15:50
