-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: inventory
-- ------------------------------------------------------
-- Server version	8.0.32-0ubuntu0.20.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Drug` (
  `drug_id` int NOT NULL AUTO_INCREMENT,
  `Drug_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Drug_code` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `batch_number` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `manufacturer` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `manufacture_date` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `expire_date` date NOT NULL,
  `origin` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `invoice_number` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `invoice_date` date NOT NULL,
  `invoice_attachment` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `single_price` double NOT NULL,
  `catagory_id` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `serial_number` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `shelf` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `shelf_row` int NOT NULL,
  `shelf_colmn` int DEFAULT NULL,
  `tag` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `num_pack` int NOT NULL,
  `qua_per_pack` int NOT NULL,
  `primary_pack` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `unit` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `temp` double NOT NULL,
  `humudity` double NOT NULL,
  `light` double NOT NULL DEFAULT '0',
  `Dossage_form` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(100) COLLATE utf8mb4_general_ci DEFAULT 'active',
  PRIMARY KEY (`drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Drug`
--

LOCK TABLES `Drug` WRITE;
/*!40000 ALTER TABLE `Drug` DISABLE KEYS */;
INSERT INTO `Drug` VALUES (20,'dsfdsfds','fsd','dsfsdd','sfdsf','2023-02-24','2023-02-25','Afghanistan','sdfdsf','2023-02-24','/home/ubuntu/img.png',54,'ANTACIDS','dsfdsf','dsfdsf',545,54,'dsfd',45,145,'Ampoule','Kg',45,45,54,'Cachet','active'),(21,'dsfdsfds','fsd','dsfsdd','sfdsf','2023-02-24','2023-02-25','Afghanistan','sdfdsf','2023-02-24','/home/ubuntu/img.png',54,'ANTACIDS','dsfdsf','dsfdsf',545,54,'dsfd',45,145,'Ampoule','Kg',45,45,54,'Cachet','disposed'),(22,'vgh','hjghj','hjghj','gh','2023-02-24','2023-02-25','Haiti','g','2023-02-24','/home/ubuntu/img.png',45,'ANTACIDS','g','hjg',5,4,'hjg',45,45,'Ampoule','Kg',4,45,45,'Gel','active'),(23,'jkhkgsg','gfgh','f','gh','2023-02-24','2023-02-25','Ghana','fh','2023-02-24','/home/ubuntu/img.png',555,'ANTACIDS','fgh','f',4,5,'f',5,5,'Ampoule','g',5,5,5,'Gel','active'),(27,'4','454','4','gert','2023-02-24','2023-02-20','Afghanistan','4','2023-02-24','64527be8-27e9-4d47-a62a-856bd773b2fa.png',412,'ANTACIDS','fgdf','4',44,45,'4',456,45,'Ampoule','Kg',445,54,412,'Cachet','disposed'),(28,'aaa','bb','tt','tgtg','2023-02-21','2023-02-28','Afghanistan','tgtgtgtgtgtgtgtgtgt','2023-02-25','8a91e539-2e82-407b-841b-e8f5aebd81b1.png',34,'ANTACIDS','tgtgtgtgtgtgtg','5',3,2,'fgfg',43,56,'Ampoule','Kg',5,44,6,'Cachet','active'),(30,'paraci','A002','dssd','adada','2023-02-26','2023-02-28','Afghanistan','vhvj','2023-02-26','files/b33a5dda-aed5-4ad9-b054-500e97fc9a36.png',25,'ZSC','hghj','1',1,2,'hjgj',2,312,'Ampoule','mg',0,0,0,'Tablet','active');
/*!40000 ALTER TABLE `Drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `catagory_id` int NOT NULL AUTO_INCREMENT,
  `catagory_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `calss_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `cat_code` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`catagory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (2,'ZSC','fdgfdg','SAFDSA');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification`
--

DROP TABLE IF EXISTS `classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classification` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `class_code` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` VALUES (4,'cfgfg','hghjf');
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `request_id` int NOT NULL AUTO_INCREMENT,
  `request_user` int NOT NULL DEFAULT '0',
  `response_user` int NOT NULL DEFAULT '0',
  `Drug_id` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` double NOT NULL,
  `unit` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `dosage` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`request_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sell` (
  `sell_id` int NOT NULL AUTO_INCREMENT,
  `drug_id` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` double NOT NULL,
  `dosage` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `unit` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `patient_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `card_number` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int NOT NULL,
  `health_center` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prescription_att` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `status` varchar(100) COLLATE utf8mb4_general_ci DEFAULT 'pending',
  PRIMARY KEY (`sell_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sell`
--

LOCK TABLES `sell` WRITE;
/*!40000 ALTER TABLE `sell` DISABLE KEYS */;
INSERT INTO `sell` VALUES (4,'dsfdsfds',454,'Powder','Kg','bfgb','12','fgbgf','Male',45,'gfbfgb','2023-02-26','/home/ubuntu/img.png','fgbgf','Paid'),(5,'dsfdsfds',2,'Tablet','mg','zzz','22222','addis ababa','Male',25,'jkh','2023-02-26','/home/ubuntu/img.png','','pending');
/*!40000 ALTER TABLE `sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(25) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `full_name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `status` int NOT NULL DEFAULT '1',
  `role` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
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

-- Dump completed on 2023-02-26 11:00:10
