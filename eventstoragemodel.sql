-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: eventstorage
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `eventdata`
--

DROP TABLE IF EXISTS `eventdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventdata` (
  `eventDataId` int(11) NOT NULL AUTO_INCREMENT,
  `eventData` varchar(200) DEFAULT NULL,
  `handlerType` varchar(45) DEFAULT NULL,
  `timestamp` int(32) DEFAULT NULL,
  PRIMARY KEY (`eventDataId`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventdata`
--

LOCK TABLES `eventdata` WRITE;
/*!40000 ALTER TABLE `eventdata` DISABLE KEYS */;
INSERT INTO `eventdata` VALUES (159,'{\"employee\":{\"id\":0,\"employeeId\":\"00012\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(160,'{\"employee\":{\"id\":0,\"employeeId\":\"00013\",\"name\":\"Pedro\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(161,'{\"register\":{\"time\":\"Nov 10, 2017 6:32:02 PM\",\"employee\":{\"id\":7,\"employeeId\":\"00008\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(162,'{\"employee\":{\"id\":0,\"employeeId\":\"00014\",\"name\":\"João\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(163,'{\"employee\":{\"id\":0,\"employeeId\":\"00015\",\"name\":\"Joao\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(164,'{\"employee\":{\"id\":0,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(165,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(166,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(167,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(168,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(169,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(170,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(171,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(172,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(173,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":7,\"employeeId\":\"00008\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(174,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":7,\"employeeId\":\"00008\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(175,'{\"employee\":{\"id\":0,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(176,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":64,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(177,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":64,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(178,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":64,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(179,'{\"employee\":{\"id\":0,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(180,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(181,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(182,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Sara\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(183,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Sara\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(184,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Sara\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(185,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"employeeId\":\"00016\",\"name\":\"Sara\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(186,'{\"employee\":{\"employeeId\":\"00001\",\"name\":\"Ceci\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(187,'{\"register\":{\"time\":\"Oct 10, 2016 6:32:02 PM\",\"employee\":{\"employeeId\":\"00001\",\"name\":\"Ceci\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(188,'{\"register\":{\"time\":\"Oct 10, 2016 11:32:02 PM\",\"employee\":{\"employeeId\":\"00001\",\"name\":\"Ceci\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0);
/*!40000 ALTER TABLE `eventdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snapshotregister`
--

DROP TABLE IF EXISTS `snapshotregister`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snapshotregister` (
  `snapshopRegisterId` int(11) NOT NULL AUTO_INCREMENT,
  `timeStamp` varchar(45) DEFAULT NULL,
  `eventDataId` int(11) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'pendent',
  PRIMARY KEY (`snapshopRegisterId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snapshotregister`
--

LOCK TABLES `snapshotregister` WRITE;
/*!40000 ALTER TABLE `snapshotregister` DISABLE KEYS */;
INSERT INTO `snapshotregister` VALUES (2,'1493642579321',159,'commited'),(3,'1493642625372',160,'commited'),(4,'1493643227346',161,'failed'),(5,'1493643227542',163,'commited'),(6,'1493643286392',164,'commited'),(7,'1493643338678',165,'failed'),(8,'1493643338800',165,'commited'),(9,'1493643418541',166,'failed'),(10,'1493643418588',166,'commited'),(11,'1493643457141',167,'failed'),(12,'1493643457178',167,'commited'),(13,'1493643688997',168,'failed'),(14,'1493643695772',169,'failed'),(15,'1493643867275',170,'failed'),(16,'1493644249663',171,'failed'),(17,'1493644256531',172,'failed'),(18,'1493644296465',173,'failed'),(19,'1493644354826',174,'failed'),(20,'1493644842357',175,'commited'),(21,'1493644863935',176,'failed'),(22,'1493645032927',177,'failed'),(23,'1493645048986',178,'failed'),(24,'1493645156410',179,'commited'),(25,'1493645168745',180,'failed'),(26,'1493645177997',181,'failed'),(27,'1493692594600',182,'failed'),(28,'1493692692305',183,'failed'),(29,'1493693705016',184,'failed'),(30,'1493693863020',185,'commited'),(31,'1493693989121',186,'commited'),(32,'1493694093477',187,'commited'),(33,'1493699466570',188,'commited');
/*!40000 ALTER TABLE `snapshotregister` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-02  1:34:35
