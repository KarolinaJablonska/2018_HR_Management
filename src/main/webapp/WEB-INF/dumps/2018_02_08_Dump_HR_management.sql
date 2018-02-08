-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: HR_database
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3l32ssuym68emkys3tbgd2hn3` (`unit_id`),
  CONSTRAINT `FK3l32ssuym68emkys3tbgd2hn3` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'','Olaf','pracownik',1),(2,'','Karol doradca','pracownik',1),(3,'','Karolina','dyrektor',2),(4,'','Konrad','kierownik',3),(5,'','Zenon','kierownik',4),(6,'','Anna','kierownik',5),(7,'','Kinga','dyrektor',6),(8,'','Stanisław','kierownik',7),(9,'','Alan','kierownik',8),(10,'','Paulina','kierownik',9),(11,'','Kamil','kierownik',10),(12,'','Tomasz','kierownik',11),(13,'','Franciszek','kierownik',12),(14,'','Kuba','kierownik',13),(15,'','Pimpek','kierownik',14),(17,'Zawada','Konrad','pracownik',3),(18,'Kowalski','Ludwik','pracownik',7);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees_training`
--

DROP TABLE IF EXISTS `employees_training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees_training` (
  `employees_id` int(11) NOT NULL,
  `trainings_id` int(11) NOT NULL,
  KEY `FK91avgkuvjbur93nr78dkg8nh6` (`trainings_id`),
  KEY `FK32saro2bwp0wwmct8s2lt6vad` (`employees_id`),
  CONSTRAINT `FK32saro2bwp0wwmct8s2lt6vad` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FK91avgkuvjbur93nr78dkg8nh6` FOREIGN KEY (`trainings_id`) REFERENCES `training` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees_training`
--

LOCK TABLES `employees_training` WRITE;
/*!40000 ALTER TABLE `employees_training` DISABLE KEYS */;
INSERT INTO `employees_training` VALUES (3,1),(3,2),(5,1),(5,2),(1,1);
/*!40000 ALTER TABLE `employees_training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `costFinal` double NOT NULL,
  `costPerPerson` double NOT NULL,
  `costPlanned` double NOT NULL,
  `costStart` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quarter` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  `unitBudget_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg9i9qp86ne6y6utdqb1d617nn` (`unitBudget_id`),
  CONSTRAINT `FKg9i9qp86ne6y6utdqb1d617nn` FOREIGN KEY (`unitBudget_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,0,0,0,60,'BHP','3','obligatoryjne',2018,1),(2,0,0,0,1000,'Zarządzanie konfliktem','3','miękkie',2018,10),(3,0,0,0,800,'Asertywność','3','miękkie',2018,10);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `training_units`
--

DROP TABLE IF EXISTS `training_units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `training_units` (
  `trainings_id` int(11) NOT NULL,
  `units_id` int(11) NOT NULL,
  KEY `FKcqtd4butwg664l7l43q2veflc` (`units_id`),
  KEY `FKe4rfl0lcdmd5rssj3uloyfsca` (`trainings_id`),
  CONSTRAINT `FKcqtd4butwg664l7l43q2veflc` FOREIGN KEY (`units_id`) REFERENCES `units` (`id`),
  CONSTRAINT `FKe4rfl0lcdmd5rssj3uloyfsca` FOREIGN KEY (`trainings_id`) REFERENCES `training` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training_units`
--

LOCK TABLES `training_units` WRITE;
/*!40000 ALTER TABLE `training_units` DISABLE KEYS */;
/*!40000 ALTER TABLE `training_units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `costFinalSum` double NOT NULL,
  `costPlannedSum` double NOT NULL,
  `costStartSum` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tBDistributed` double NOT NULL,
  `tBLeft` double NOT NULL,
  `trainingBudget` double NOT NULL,
  `unitType` varchar(255) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `parentUnit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8kxgeqmyjycqvjs7seo1q45wl` (`manager_id`),
  KEY `FKqsarns7g0sq1cbhtxh34j2w1s` (`parentUnit_id`),
  CONSTRAINT `FK8kxgeqmyjycqvjs7seo1q45wl` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`id`),
  CONSTRAINT `FKqsarns7g0sq1cbhtxh34j2w1s` FOREIGN KEY (`parentUnit_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,0,0,0,'Zarząd',6000,0,6000,'zarząd',1,NULL),(2,0,0,0,'Nudny HR',1500,-1000,500,'jednostka',3,1),(3,0,0,0,'Wydział Zatrudnienia',0,0,500,'wydział',4,2),(4,0,0,0,'Dział Podwładnych',0,0,0,'dział',5,3),(5,0,0,0,'Dział Wypasiony',0,0,0,'dział',6,3),(6,0,0,0,'Οἶδα οὐδὲν εἰδώς',900,800,1700,'jednostka',7,1),(7,0,0,0,'Wydział Gier',0,0,300,'wydział',8,6),(8,0,0,0,'Dział Gry księżniczki Nadji',0,0,0,'dział',9,7),(9,0,0,0,'Dział Wypasione gry karciane',0,0,0,'dział',10,7),(10,0,0,0,'Wydział Show must go on',0,0,0,'wydział',11,6),(11,0,0,0,'Dział Imprezy żaglarskie + egzamin',0,0,0,'dział',12,10),(12,0,0,0,'Dział Budowlano-medyczne',0,0,0,'dział',13,10),(13,0,0,0,'Dział Imprez bankowych',0,0,0,'dział',14,10),(14,0,0,0,'Wydział Koci',0,0,0,'wydział',15,6),(15,0,0,0,'Dział IT',0,0,0,'dział',9,3),(16,0,0,0,'Dział Księgowy',0,0,0,'dział',18,7);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-08 12:27:11
