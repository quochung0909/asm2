-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: asm2
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `applypost`
--

DROP TABLE IF EXISTS `applypost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applypost` (
  `idapplypost` int NOT NULL AUTO_INCREMENT,
  `created_at` varchar(255) DEFAULT NULL,
  `recruitment_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `name_cv` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idapplypost`),
  KEY `fk_recruitment_app_idx` (`recruitment_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_recruitment_app` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`idrecruitment`),
  CONSTRAINT `fk_user_app` FOREIGN KEY (`user_id`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applypost`
--

LOCK TABLES `applypost` WRITE;
/*!40000 ALTER TABLE `applypost` DISABLE KEYS */;
INSERT INTO `applypost` VALUES (1,'2024-01-31',1,9,'Vienna-Modern-Resume-Template.pdf',1,'Tôi là Nguyễn Thiên Ân'),(2,'2024-01-31',3,8,'OIP.jpg',1,''),(3,'2024-03-06',1,8,'046f4526068dabd3f29c.jpg',1,'');
/*!40000 ALTER TABLE `applypost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `idcategory` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `number_choose` int DEFAULT NULL,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'NODEJS',4),(2,'PHP',6),(3,'JAVA',3),(4,'ASP.NET',4);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `idcompany` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `description` longtext,
  `email` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `name_company` varchar(255) DEFAULT NULL,
  `phone_company` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`idcompany`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'123 abc, Cầu Giấy, Hà Nội','Công ty cung cấp nước','cungcapnuoc@gmail.com','http://res.cloudinary.com/dbp1j0254/image/upload/v1706524013/ktk6lpevvvco3zvohccz.jpg','Công ty TNHH cung cấp nước Hà Nội','0123456789',1,7);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv`
--

DROP TABLE IF EXISTS `cv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cv` (
  `idcv` int NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`idcv`),
  KEY `fk_user_cv_idx` (`user_id`),
  CONSTRAINT `fk_user_cv` FOREIGN KEY (`user_id`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv`
--

LOCK TABLES `cv` WRITE;
/*!40000 ALTER TABLE `cv` DISABLE KEYS */;
INSERT INTO `cv` VALUES (3,'Vienna-Modern-Resume-Template.pdf',9);
/*!40000 ALTER TABLE `cv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_company`
--

DROP TABLE IF EXISTS `follow_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow_company` (
  `idfollow_company` int NOT NULL AUTO_INCREMENT,
  `company_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`idfollow_company`),
  KEY `fk_company_fc_idx` (`company_id`),
  KEY `fk_user_fc_idx` (`user_id`),
  CONSTRAINT `fk_company_fc` FOREIGN KEY (`company_id`) REFERENCES `company` (`idcompany`),
  CONSTRAINT `fk_user_fc` FOREIGN KEY (`user_id`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_company`
--

LOCK TABLES `follow_company` WRITE;
/*!40000 ALTER TABLE `follow_company` DISABLE KEYS */;
INSERT INTO `follow_company` VALUES (1,1,8);
/*!40000 ALTER TABLE `follow_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruitment`
--

DROP TABLE IF EXISTS `recruitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recruitment` (
  `idrecruitment` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `view` varchar(255) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `company_id` int DEFAULT NULL,
  `deadline` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idrecruitment`),
  KEY `FKtj8cu8x5ar1c5hmu0j3veteit` (`category_id`),
  KEY `fk_category_idx` (`company_id`,`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`idcategory`),
  CONSTRAINT `fk_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`idcompany`),
  CONSTRAINT `FKtj8cu8x5ar1c5hmu0j3veteit` FOREIGN KEY (`category_id`) REFERENCES `category` (`idcategory`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruitment`
--

LOCK TABLES `recruitment` WRITE;
/*!40000 ALTER TABLE `recruitment` DISABLE KEYS */;
INSERT INTO `recruitment` VALUES (1,'129/23/12 Hoàng Văn Thụ, Phường 8','2024-01-30','<p>Tuyển lập trình viên .NET kinh nghiệm 1 năm</p>','1 năm',2,NULL,'12000000',1,'Tuyển lập trình viên .NET ','Full time',NULL,4,1,'2024-02-29'),(3,'129/23/12 Hoàng Văn Thụ, Phường 9','2024-01-30','<p>Tuyển lập trình viên PHP 5 năm kinh nghiệm</p>','5 năm',1,NULL,'25000000',1,'Tuyển lập trình viên PHP','Full time',NULL,2,1,'2024-03-16');
/*!40000 ALTER TABLE `recruitment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `idrole` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Ứng cử viên'),(2,'Công ty');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `save_job`
--

DROP TABLE IF EXISTS `save_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `save_job` (
  `idsave_job` int NOT NULL AUTO_INCREMENT,
  `recruitment_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`idsave_job`),
  KEY `fk_recruitment_idx` (`recruitment_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_recruitment` FOREIGN KEY (`recruitment_id`) REFERENCES `recruitment` (`idrecruitment`),
  CONSTRAINT `fk_user_sj` FOREIGN KEY (`user_id`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_job`
--

LOCK TABLES `save_job` WRITE;
/*!40000 ALTER TABLE `save_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `save_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `iduser` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `cv_id` int DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  KEY `fk_role_idx` (`role_id`),
  KEY `fk_cv_idx` (`cv_id`),
  CONSTRAINT `fk_cv` FOREIGN KEY (`cv_id`) REFERENCES `cv` (`idcv`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`idrole`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (5,'Thôn 5, Tâm Thắng','<p>Haha</p>','thienan9924@gmail.com','Nguyễn Thiên Ân',NULL,'$2a$10$aO.9oJLPwqA4PrUcmt5sqO.T80J0SQChzg0GnTx10iERmb8vWmHPO','0522956799',1,2,NULL),(7,'New York','','quochung99201@gmail.com','Nguyễn Quốc Hưng','http://res.cloudinary.com/dbp1j0254/image/upload/v1706523472/ye9qaxbqk58nuggahmhz.jpg','$2a$10$aO.9oJLPwqA4PrUcmt5sqO.T80J0SQChzg0GnTx10iERmb8vWmHPO','0987654321',1,2,NULL),(8,NULL,NULL,'quochung99202@gmail.com','Nguyễn Quốc Hưng',NULL,'$2a$10$aO.9oJLPwqA4PrUcmt5sqO.T80J0SQChzg0GnTx10iERmb8vWmHPO',NULL,1,1,NULL),(9,'Quận 8, TP HCM','<p>Lập trình viên</p>','thienan99242@gmail.com','Nguyễn Thiên Ân','http://res.cloudinary.com/dbp1j0254/image/upload/v1706631760/xbbcpkhtnvb9eqwjcuuo.jpg','$2a$10$ZfmvV76a/e0imzCR.EzTguArhrY4dEDtPrumI5Z3t1rJ7irVttnRu','0123455643',1,1,3),(10,NULL,NULL,'quochung99203@gmail.com','Nguyễn Quốc Hưng',NULL,'$2a$10$8wvh0FUHm7iyR07j8n/CYOsgUlZe0MeF6IU8kNlKC7viaRZypA7zm',NULL,1,1,NULL),(11,NULL,NULL,'quochung9920@gmail.com','Nguyễn Quốc Hưng',NULL,'$2a$10$ND2UhmsetXPHEWkc1WrREOwnnuMAzB1Rxnn2vo95QOV9YSD.wbY3e',NULL,1,2,NULL);
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

-- Dump completed on 2024-03-06 22:52:31
