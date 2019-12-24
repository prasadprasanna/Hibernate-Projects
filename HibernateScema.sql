CREATE DATABASE  IF NOT EXISTS `hibernate` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hibernate`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hibernate
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `CATEGORY_ID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRPTION` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Information Technolog','IT'),(2,'Manifacturing','MAN'),(3,'Consulting','CON'),(4,'Finance','FIN'),(5,'Banking','BANK');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `street_name` varchar(40) DEFAULT NULL,
  `city_name` varchar(40) DEFAULT NULL,
  `state_name` varchar(40) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'David','Nix',3000,'3375 Spring Hill Pwky','Smyrna','GA','30080');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `STOCK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STOCK_CODE` varchar(45) NOT NULL,
  `STOCK_NAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`STOCK_ID`),
  UNIQUE KEY `STOCK_CODE_UNIQUE` (`STOCK_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='STOCK_ID	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (100,'APPLE','Apple Inc'),(101,'2626','AMRA'),(104,'1018','HRAC');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_category`
--

DROP TABLE IF EXISTS `stock_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_category` (
  `CATEGORY_ID` int(11) NOT NULL,
  `STOCK_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_category`
--

LOCK TABLES `stock_category` WRITE;
/*!40000 ALTER TABLE `stock_category` DISABLE KEYS */;
INSERT INTO `stock_category` VALUES (1,100),(2,100);
/*!40000 ALTER TABLE `stock_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_daily_record`
--

DROP TABLE IF EXISTS `stock_daily_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_daily_record` (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STOCK_ID` int(11) DEFAULT NULL,
  `PRICE_OPEN` decimal(5,0) DEFAULT NULL,
  `PRICE_CLOSE` decimal(5,0) DEFAULT NULL,
  `PRICE_CHANGE` varchar(5) DEFAULT NULL,
  `VOLUME` varchar(5) DEFAULT NULL,
  `DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_daily_record`
--

LOCK TABLES `stock_daily_record` WRITE;
/*!40000 ALTER TABLE `stock_daily_record` DISABLE KEYS */;
INSERT INTO `stock_daily_record` VALUES (1,100,100,102,'2','100',NULL),(2,100,102,99,'3','121',NULL),(3,104,11,1,'10.0','400','2019-12-20 00:00:00');
/*!40000 ALTER TABLE `stock_daily_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_detail`
--

DROP TABLE IF EXISTS `stock_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_detail` (
  `STOCK_ID` int(11) NOT NULL,
  `COMP_NAME` varchar(45) DEFAULT NULL,
  `COMP_DESC` varchar(45) DEFAULT NULL,
  `REMARK` varchar(45) DEFAULT NULL,
  `LISTED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`STOCK_ID`),
  CONSTRAINT `STOCK_ID` FOREIGN KEY (`STOCK_ID`) REFERENCES `stock` (`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_detail`
--

LOCK TABLES `stock_detail` WRITE;
/*!40000 ALTER TABLE `stock_detail` DISABLE KEYS */;
INSERT INTO `stock_detail` VALUES (100,'Apple Inc','Information Technology','Good Stock',NULL),(101,'American Airlines','Airline Company','Popular in ALL USA','2019-12-20 00:00:00');
/*!40000 ALTER TABLE `stock_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-23 20:29:08
