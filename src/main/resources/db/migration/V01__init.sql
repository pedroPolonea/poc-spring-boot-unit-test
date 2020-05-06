-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: everyday
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appointed_day`
--

DROP TABLE IF EXISTS `appointed_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointed_day` (
  `idAppointed` int(11) NOT NULL AUTO_INCREMENT,
  `idTeam` int(11) NOT NULL,
  `idMotivations` int(11) NOT NULL,
  `idCostCenter` int(11) NOT NULL,
  `day` date NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idAppointed`),
  UNIQUE KEY `idAppointed_UNIQUE` (`idAppointed`),
  KEY `fk__idx` (`idCostCenter`),
  KEY `fk__idx1` (`idTeam`),
  KEY `fk_idx` (`idMotivations`),
  KEY `fk_User_idx` (`idUser`),
  CONSTRAINT `fk_CostCenter` FOREIGN KEY (`idCostCenter`) REFERENCES `cost_center` (`idcostcenter`),
  CONSTRAINT `fk_Motivations` FOREIGN KEY (`idMotivations`) REFERENCES `motivations` (`idmotivations`),
  CONSTRAINT `fk_Team` FOREIGN KEY (`idTeam`) REFERENCES `team` (`idteam`),
  CONSTRAINT `fk_User` FOREIGN KEY (`idUser`) REFERENCES `user` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointed_day`
--

LOCK TABLES `appointed_day` WRITE;
/*!40000 ALTER TABLE `appointed_day` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointed_day` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost_center`
--

DROP TABLE IF EXISTS `cost_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cost_center` (
  `idCostCenter` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `dtCreation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idCostCenter`),
  UNIQUE KEY `idcost_center_UNIQUE` (`idCostCenter`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost_center`
--

LOCK TABLES `cost_center` WRITE;
/*!40000 ALTER TABLE `cost_center` DISABLE KEYS */;
INSERT INTO `cost_center` VALUES (1,'PRV DEV – Equipe Dedicada','2018-08-06 23:31:02',1);
/*!40000 ALTER TABLE `cost_center` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivations`
--

DROP TABLE IF EXISTS `motivations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `motivations` (
  `idMotivations` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `dtCreation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMotivations`),
  UNIQUE KEY `idmotivations_UNIQUE` (`idMotivations`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivations`
--

LOCK TABLES `motivations` WRITE;
/*!40000 ALTER TABLE `motivations` DISABLE KEYS */;
INSERT INTO `motivations` VALUES (1,'Banco de horas','2018-08-06 23:29:50',1);
/*!40000 ALTER TABLE `motivations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pointing`
--

DROP TABLE IF EXISTS `pointing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pointing` (
  `idPointing` int(11) NOT NULL AUTO_INCREMENT,
  `dtInput` datetime NOT NULL,
  `dtOut` datetime DEFAULT NULL,
  `idAppointed` int(11) NOT NULL,
  PRIMARY KEY (`idPointing`),
  UNIQUE KEY `idPointing_UNIQUE` (`idPointing`),
  KEY `fk__idx` (`idAppointed`),
  CONSTRAINT `fk_Appointed` FOREIGN KEY (`idAppointed`) REFERENCES `appointed_day` (`idappointed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pointing`
--

LOCK TABLES `pointing` WRITE;
/*!40000 ALTER TABLE `pointing` DISABLE KEYS */;
/*!40000 ALTER TABLE `pointing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `team` (
  `idteam` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `dtCreation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idteam`),
  UNIQUE KEY `idteam_UNIQUE` (`idteam`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'UOL PagSeguro','2018-08-06 23:30:30',1);
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `login` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `dtCreation` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) unsigned zerofill NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2018-09-07 22:43:41
