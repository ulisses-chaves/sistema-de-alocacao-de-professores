-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sap
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.30-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professor` (
  `CPF` int(11) NOT NULL,
  `Nome` varchar(40) NOT NULL,
  `Area` enum('FC','Arc','Ensiso') NOT NULL,
  `FK_Disciplina_Preferencia_1` int(5) DEFAULT NULL,
  `FK_Disciplina_Preferencia_2` int(5) DEFAULT NULL,
  `login` varchar(30) NOT NULL,
  `cargo` enum('PROFESSOR','COORDENADOR','SUPERVISOR') DEFAULT NULL,
  `senha` varchar(150) NOT NULL,
  PRIMARY KEY (`CPF`),
  UNIQUE KEY `login` (`login`),
  KEY `FK_Disciplina_Preferencia_1` (`FK_Disciplina_Preferencia_1`),
  KEY `FK_Disciplina_Preferencia_2` (`FK_Disciplina_Preferencia_2`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1232,'NOME','Ensiso',NULL,NULL,'prof','PROFESSOR','$2a$10$NktDIbpJMyAv2yNzuipqzu4kSGy.8jYtYVsRV140MAyR8VSrvlRR.'),(1234,'rodemarck','Ensiso',NULL,NULL,'rode','PROFESSOR','$2a$10$xu8K04NpPutppxYwdgLrcuFAF3ptgyCsEKSRMP6WF7F.Wy0UnRo4i');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-02 16:02:09
