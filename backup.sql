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
-- Current Database: `inventory`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `inventory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `inventory`;

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
  `status` varchar(100) DEFAULT 'active',
  PRIMARY KEY (`drug_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Drug`
--

LOCK TABLES `Drug` WRITE;
/*!40000 ALTER TABLE `Drug` DISABLE KEYS */;
INSERT INTO `Drug` VALUES (15,'fghgfhgfh','fghgfh','fghfg','gfhgf','2023-02-20','2023-02-20','Afghanistan','fghgfh','2023-02-20','/home/user/sudo',43534,'ANTACIDS','45435','45',345,45,'454',45,45,'Ampoule','Kg',435,4354,43543,'Cachet','active');
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
  `calss_name` varchar(100) NOT NULL,
  `cat_code` varchar(100) NOT NULL,
  PRIMARY KEY (`catagory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'ANTACIDS','GASTRO...','GI.100'),(2,'ZSC','fdgfdg','SAFDSA'),(3,'SADASD','fdgfdg','SAFDSA'),(4,'','GASTRO...','');
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
  `class_code` varchar(100) NOT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` VALUES (1,'fdgfdg','dfgfdg'),(2,'GASTRO...','GI.000');
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

-- Dump completed on 2023-02-20 16:29:15
