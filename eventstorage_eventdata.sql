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
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventdata`
--

LOCK TABLES `eventdata` WRITE;
/*!40000 ALTER TABLE `eventdata` DISABLE KEYS */;
INSERT INTO `eventdata` VALUES (159,'{\"employee\":{\"id\":0,\"employeeId\":\"00012\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(160,'{\"employee\":{\"id\":0,\"employeeId\":\"00013\",\"name\":\"Pedro\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(161,'{\"register\":{\"time\":\"Nov 10, 2017 6:32:02 PM\",\"employee\":{\"id\":7,\"employeeId\":\"00008\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(162,'{\"employee\":{\"id\":0,\"employeeId\":\"00014\",\"name\":\"João\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(163,'{\"employee\":{\"id\":0,\"employeeId\":\"00015\",\"name\":\"Joao\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(164,'{\"employee\":{\"id\":0,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(165,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(166,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(167,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(168,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(169,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(170,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(171,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(172,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":62,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(173,'{\"register\":{\"time\":\"Dec 10, 2017 6:32:02 PM\",\"employee\":{\"id\":7,\"employeeId\":\"00008\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(174,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":7,\"employeeId\":\"00008\",\"name\":\"Carlos\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(175,'{\"employee\":{\"id\":0,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(176,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":64,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(177,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":64,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(178,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":64,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(179,'{\"employee\":{\"id\":0,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}','com.register.api.events.SignUpEmployeeHandler',0),(180,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0),(181,'{\"register\":{\"time\":\"Oct 10, 2017 6:32:02 PM\",\"employee\":{\"id\":65,\"employeeId\":\"00016\",\"name\":\"Regina\",\"encryptedPass\":\"MTIzNDU\\u003d\"}}}','com.register.api.events.CreateRegisterHandler',0);
/*!40000 ALTER TABLE `eventdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-01 10:28:33
