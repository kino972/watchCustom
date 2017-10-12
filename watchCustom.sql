-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: watchCustom
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `caracteristic_category`
--

DROP TABLE IF EXISTS `caracteristic_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristic_category` (
  `caracteristic_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_category_id` int(11) DEFAULT NULL,
  `fk_caracteristic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`caracteristic_category_id`),
  KEY `fk_caracteristic_id_idx` (`fk_caracteristic_id`),
  KEY `fk_category_id_idx` (`fk_category_id`),
  CONSTRAINT `fk_caracteristic_id` FOREIGN KEY (`fk_caracteristic_id`) REFERENCES `caracteristic_name` (`caracteristic_name_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_id` FOREIGN KEY (`fk_category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristic_category`
--

LOCK TABLES `caracteristic_category` WRITE;
/*!40000 ALTER TABLE `caracteristic_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `caracteristic_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristic_name`
--

DROP TABLE IF EXISTS `caracteristic_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristic_name` (
  `caracteristic_name_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`caracteristic_name_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristic_name`
--

LOCK TABLES `caracteristic_name` WRITE;
/*!40000 ALTER TABLE `caracteristic_name` DISABLE KEYS */;
/*!40000 ALTER TABLE `caracteristic_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristic_value`
--

DROP TABLE IF EXISTS `caracteristic_value`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristic_value` (
  `caracteristic_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`caracteristic_value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristic_value`
--

LOCK TABLES `caracteristic_value` WRITE;
/*!40000 ALTER TABLE `caracteristic_value` DISABLE KEYS */;
/*!40000 ALTER TABLE `caracteristic_value` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristicname_caracteristicvalue`
--

DROP TABLE IF EXISTS `caracteristicname_caracteristicvalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicname_caracteristicvalue` (
  `caracteristicname_caracteristicvalue_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_caracteristic_value_id` int(11) DEFAULT NULL,
  `fk_caracteristic_name_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`caracteristicname_caracteristicvalue_id`),
  KEY `caracteristic_name_id_idx` (`fk_caracteristic_name_id`),
  KEY `caracteristic_name_id_id` (`fk_caracteristic_name_id`),
  KEY `fk_caracteristicname_caracteristicvalue_1_idx` (`fk_caracteristic_value_id`),
  CONSTRAINT `fk_caracteristic_name_id` FOREIGN KEY (`fk_caracteristic_name_id`) REFERENCES `caracteristic_name` (`caracteristic_name_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_caracteristic_value_id` FOREIGN KEY (`fk_caracteristic_value_id`) REFERENCES `caracteristic_value` (`caracteristic_value_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicname_caracteristicvalue`
--

LOCK TABLES `caracteristicname_caracteristicvalue` WRITE;
/*!40000 ALTER TABLE `caracteristicname_caracteristicvalue` DISABLE KEYS */;
/*!40000 ALTER TABLE `caracteristicname_caracteristicvalue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `street_no` int(11) NOT NULL,
  `street_name` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  `gender` int(11) NOT NULL,
  `phone_number` int(11) NOT NULL,
  `clientcol` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `command`
--

DROP TABLE IF EXISTS `command`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `command` (
  `command_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_product_id` int(11) NOT NULL,
  `fk_client_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`command_id`),
  KEY `fk_client_id_idx` (`fk_client_id`),
  CONSTRAINT `fk_client_id` FOREIGN KEY (`fk_client_id`) REFERENCES `client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `command`
--

LOCK TABLES `command` WRITE;
/*!40000 ALTER TABLE `command` DISABLE KEYS */;
/*!40000 ALTER TABLE `command` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photo`
--

DROP TABLE IF EXISTS `photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photo` (
  `photo_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photo`
--

LOCK TABLES `photo` WRITE;
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `fk_product_image_id` int(11) DEFAULT NULL,
  `fk_vendor_id` int(11) DEFAULT NULL,
  `fk_statistic_id` int(11) DEFAULT NULL,
  `fk_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `title_UNIQUE` (`title`),
  KEY `fk_product_1_idx` (`fk_category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`fk_category_id`) REFERENCES `category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (3,'chaupard watch','a superb chaupard watc',900,NULL,NULL,NULL,NULL),(4,'rolex watch','a vintage rolex watch',1500,NULL,NULL,NULL,NULL),(5,'omega watch','new omega watch',3000,NULL,NULL,NULL,NULL),(9,'eta valjoux 5510','automatic swiss movement 25 jewerly',400,NULL,NULL,NULL,NULL),(10,'case for eta valjoux 5510','titanium case for valjoux 5510',100,NULL,NULL,NULL,NULL),(11,'leather straps 20 mm','leather straps 20mm premium quality',20,NULL,NULL,NULL,NULL),(12,'eta valjoux 6520','new automatic swiss movement must have',600,NULL,NULL,NULL,NULL),(13,'universal case','a case tha can fit most swiss movement',200,NULL,NULL,NULL,NULL),(14,'steel strap','strong steel straps 25 mm',100,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_command`
--

DROP TABLE IF EXISTS `product_command`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_command` (
  `product_command_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_fk_id` int(11) NOT NULL,
  `command_fk_id` int(11) NOT NULL,
  PRIMARY KEY (`product_command_id`),
  KEY `fk_product_idx` (`product_fk_id`),
  CONSTRAINT `fk_command` FOREIGN KEY (`product_fk_id`) REFERENCES `command` (`command_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product` FOREIGN KEY (`product_fk_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_command`
--

LOCK TABLES `product_command` WRITE;
/*!40000 ALTER TABLE `product_command` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_command` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_photo`
--

DROP TABLE IF EXISTS `product_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_photo` (
  `product_photo_id` int(11) NOT NULL,
  `fk_product_id` int(11) NOT NULL,
  `fk_photo_id` int(11) NOT NULL,
  PRIMARY KEY (`product_photo_id`),
  KEY `fk_product_photo_1_idx` (`fk_photo_id`),
  KEY `fk_product_photo_2_idx` (`fk_product_id`),
  CONSTRAINT `fk_product_photo_1` FOREIGN KEY (`fk_photo_id`) REFERENCES `photo` (`photo_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_photo_2` FOREIGN KEY (`fk_product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_photo`
--

LOCK TABLES `product_photo` WRITE;
/*!40000 ALTER TABLE `product_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tag`
--

DROP TABLE IF EXISTS `product_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_tag` (
  `product_tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_product_id` int(11) DEFAULT NULL,
  `fk_tag_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_tag_id`),
  KEY `tag_id_idx` (`fk_tag_id`),
  KEY `product_id_idx` (`fk_product_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`fk_product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tag_id` FOREIGN KEY (`fk_tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tag`
--

LOCK TABLES `product_tag` WRITE;
/*!40000 ALTER TABLE `product_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `step` (
  `step_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`step_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step`
--

LOCK TABLES `step` WRITE;
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
INSERT INTO `step` VALUES (1,'Choose your watch'),(2,'payment');
/*!40000 ALTER TABLE `step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_step`
--

DROP TABLE IF EXISTS `sub_step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_step` (
  `sub_step_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `fk_sub_step_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sub_step_id`),
  KEY `step_id_idx` (`fk_sub_step_id`),
  CONSTRAINT `step_id` FOREIGN KEY (`fk_sub_step_id`) REFERENCES `step` (`step_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_step`
--

LOCK TABLES `sub_step` WRITE;
/*!40000 ALTER TABLE `sub_step` DISABLE KEYS */;
INSERT INTO `sub_step` VALUES (1,'choose your movement',1),(2,'choose your case',1),(3,'choose dial and hands',1),(4,'choose straps',1),(5,'check out your cart',2),(6,'fill in payment info',2),(7,'confirm payment',2);
/*!40000 ALTER TABLE `sub_step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'used'),(2,'new'),(3,'premium'),(4,'vintage'),(5,'DIY');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-07 21:16:07
