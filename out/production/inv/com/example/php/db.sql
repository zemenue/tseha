-- MariaDB dump 10.19  Distrib 10.6.11-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	10.6.11-MariaDB-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Drug`
--

DROP TABLE IF EXISTS `Drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `Drug_name` varchar(100) NOT NULL,
  `Drug_code` varchar(100) NOT NULL,
  `batch_number` varchar(100) NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `manufacture_date` varchar(50) NOT NULL,
  `expire_date` date NOT NULL,
  `origin` varchar(100) NOT NULL,
  `invoice_number` varchar(100) NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_attachment` varchar(100) NOT NULL,
  `single_price` double NOT NULL,
  `catagory_id` varchar(100) NOT NULL,
  `serial_number` varchar(100) NOT NULL,
  `shelf` varchar(100) NOT NULL,
  `shelf_row` int(11) NOT NULL,
  `shelf_colmn` int(11) DEFAULT NULL,
  `tag` varchar(100) NOT NULL,
  `num_pack` int(11) NOT NULL,
  `qua_per_pack` int(11) NOT NULL,
  `primary_pack` varchar(100) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `temp` double NOT NULL,
  `humudity` double NOT NULL,
  `light` double NOT NULL DEFAULT 0,
  `Dossage_form` varchar(100) NOT NULL,
  PRIMARY KEY (`drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Drug`
--

LOCK TABLES `Drug` WRITE;
/*!40000 ALTER TABLE `Drug` DISABLE KEYS */;
INSERT INTO `Drug` VALUES (3,'paracitamol','0004 padfsf','0021f','aaaaa','2023-02-14','2023-02-14','Afghanistan','1232','2023-02-14','/home/user/java.zip',2222,'ras mitat','e23eee3','1',1,2,'12',12,12,'Ampoule','Kg',11,22,23,'Cachet'),(4,'qadsaf','sdfds','sdfdsf','sdfdsf','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','111',11,'ras mitat','1','1',1,1,'1',1,1,'Ampoule','Kg',1,1,111,'Cachet'),(5,'qadsaf','sdfds','sdfdsf','sdfdsf','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','111',11,'ras mitat','1','1',1,1,'1',1,1,'Ampoule','Kg',1,1,111,'Cachet'),(6,'1111111111','111','11','1','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','1',1,'ras mitat','11','11',111,111,'1',1,1,'Ampoule','Kg',1,1,1,'Cachet'),(7,'1111111111','111','11','1','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','1',1,'ras mitat','11','11',111,111,'1',1,1,'Ampoule','Kg',1,1,1,'Cachet'),(8,'1111111111','111','11','1','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','1',1,'ras mitat','11','11',111,111,'1',1,1,'Ampoule','Kg',1,1,1,'Cachet'),(9,'qqqqqqq','1','1','1','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','1',1,'ras mitat','1','1',1,1,'1',1,1,'Ampoule','Kg',1,1,1,'Cachet'),(10,'qqqqqqq','1','1','1','2023-02-14','2023-02-14','Afghanistan','1','2023-02-14','1',1,'ras mitat','1','1',1,1,'1',1,1,'Ampoule','Kg',1,1,1,'Cachet'),(11,'ewfsdfsd','sdfds','12d','1sdffsd','2023-02-14','2023-02-14','Afghanistan','222','2023-02-14','2222',2222,'ras mitat','2222','2',2,2,'2',2,2,'Ampoule','Kg',2,2,2,'Cachet'),(12,'222222222','1','1','1','2023-02-17','2023-02-17','Afghanistan','1','2023-02-17','1',1,'ras mitat','1','1',1,1,'1',1,1,'Ampoule','Kg',1,1,1,'Cachet'),(13,'33333','qw','213','213','2023-02-17','2023-02-17','Afghanistan','213','2023-02-17','213',123,'ras mitat','213','213',213,23,'123',213,123,'Ampoule','Kg',2132,123,213,'Cachet'),(14,'paracitamol','004jghjghj','43543','flegeb','2018-01-01','2024-02-09','Andorra','1212312','2023-02-17','/home/user/gfrgh',25,'ras mitat','3423423','3',2,4,'34534',2,12,'Ampoule','mg',25,5,2,'Tablet');
/*!40000 ALTER TABLE `Drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `catagory_id` int(11) NOT NULL AUTO_INCREMENT,
  `catagory_name` varchar(100) NOT NULL,
  `calss_id` int(11) NOT NULL,
  PRIMARY KEY (`catagory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification`
--

DROP TABLE IF EXISTS `classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(100) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `request_user` int(11) NOT NULL,
  `response_user` int(11) NOT NULL,
  `Drug_id` int(11) NOT NULL,
  `quantity` double NOT NULL,
  `unit` varchar(100) NOT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sell`
--

DROP TABLE IF EXISTS `sell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sell` (
  `sell_id` int(11) NOT NULL,
  `drug_id` int(11) NOT NULL,
  `quantity` double NOT NULL,
  `dosage` varchar(100) NOT NULL,
  `unit` varchar(100) NOT NULL,
  `patient_name` varchar(100) NOT NULL,
  `card_number` varchar(100) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `sex` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `health_center` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `prescription_att` varchar(100) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sell_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sell`
--

LOCK TABLES `sell` WRITE;
/*!40000 ALTER TABLE `sell` DISABLE KEYS */;
/*!40000 ALTER TABLE `sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(25) DEFAULT NULL,
  `full_name` varchar(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 1,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (10,'admin','admin','zem@gmail.com','zemen endale',1,'admin'),(11,'admin2','admin2','zemm@','admin admin',2,'admmin'),(12,'fdgdf','fdgfd','dfgfdg','fdgdf',2,'fdgfd'),(13,'fdgdf','fdgfd','dfgfdg','fdgdf',2,'fdgfd'),(14,'fdgdf','fdgfd','dfgfdg','fdgdf',2,'fdgfd'),(15,'mjhmjhjk','nmbhn','hfghfhj','fhgf',2,'Store Keeper'),(16,'mjhmjhjk','nmbhn','hfghfhj','tsehay',2,'Pharmacist'),(17,'dsfd','dsfd','dsfsd','fdsfd',2,'Store Keeper'),(18,'zzzz','[B@333add7e','zzz','zzz',2,'Pharmacist');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-17 16:21:30
