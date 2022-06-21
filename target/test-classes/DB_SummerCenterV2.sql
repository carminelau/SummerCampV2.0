CREATE DATABASE  IF NOT EXISTS `summer_center` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `summer_center`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: summer_center
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `bambino`
--

DROP TABLE IF EXISTS `bambino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bambino` (
  `codiceFiscale` varchar(16) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `dataNascita` date NOT NULL,
  `luogoNascita` varchar(255) NOT NULL,
  `disabilita` tinyint DEFAULT '0',
  `documentoIdentita` varchar(512) NOT NULL,
  `ausilioMaterialeGalleggiante` tinyint DEFAULT '0',
  `certificatoMedico` varchar(512) NOT NULL,
  `farmaci` varchar(512) DEFAULT NULL,
  `infoEsigenzeAlimentari` varchar(512) DEFAULT NULL,
  `esigenzeAlimentari` tinyint DEFAULT '0',
  `tagliaIndumenti` varchar(10) NOT NULL,
  `cfGenitore` varchar(16) NOT NULL,
  `infoAllergie` varchar(512) DEFAULT NULL,
  `genere` char(1) DEFAULT NULL,
  PRIMARY KEY (`codiceFiscale`),
  KEY `cfGenitore_idx` (`cfGenitore`),
  CONSTRAINT `cfGenitore` FOREIGN KEY (`cfGenitore`) REFERENCES `utente` (`codiceFiscaleUtente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bambino`
--

LOCK TABLES `bambino` WRITE;
/*!40000 ALTER TABLE `bambino` DISABLE KEYS */;
INSERT INTO `bambino` VALUES ('ANTCLM02E12R431A','Marco','Esposito','2014-07-12','Pagani',0,'/',1,'/','0','nessuna',0,'M','SPSVCN04E09C321S',NULL,'M'),('BNNTRYEUDIC15267','Luigi','Donnarumma','2014-09-10','Napoli',0,'/',1,'/','0','nessuna',0,'M','DNNGRD12D05F456D',NULL,'M'),('DDDPLC10A45D321A','Paola','Dalia','2017-04-05','Angri',0,'/',1,'/','0','nessuna',0,'M','DADANT22C05C234S',NULL,'F'),('GNLRSS06R02C987S','Gianluca','Rossi','2015-04-04','Pagani',0,'4_5926846704300068028.pdf',1,'4_5926846704300068028.pdf','0','nessuna ',0,'M','MRARSS00E02F123S','0','M'),('ZZPALF12D02C213S','Eustacchio','Esposito','2012-10-09','Pagani',1,'8-mobileIP.pdf',0,'8-mobileIP.pdf','0','0',1,'S','MRARSS00E02F123S','0','M'),('ZZPALF12D02C321S','Alfonso','Esposito','2013-02-03','Angri',0,'/',1,'/','0','nessuna',0,'M','SPSVCN04E09C321S',NULL,'M');
/*!40000 ALTER TABLE `bambino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centro`
--

DROP TABLE IF EXISTS `centro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centro` (
  `idcentro` int NOT NULL AUTO_INCREMENT,
  `denominazione` varchar(255) NOT NULL,
  `indirizzo` varchar(255) NOT NULL,
  `capienzaTot` int NOT NULL DEFAULT '50',
  `comune` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `cancellato` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`idcentro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centro`
--

LOCK TABLES `centro` WRITE;
/*!40000 ALTER TABLE `centro` DISABLE KEYS */;
INSERT INTO `centro` VALUES (2,'Olimpia Sport','Via De Lucia 10',70,'Salerno','Salerno',0),(3,'Drive\'s & Drive\'s','Via Alcide De Gasperi 1',50,'Pagani','Pagani',0);
/*!40000 ALTER TABLE `centro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centrosettimana`
--

DROP TABLE IF EXISTS `centrosettimana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centrosettimana` (
  `idcentro` int NOT NULL,
  `idsettimana` int NOT NULL,
  `disponibilita` int NOT NULL DEFAULT '50',
  `id` int NOT NULL,
  PRIMARY KEY (`idcentro`,`idsettimana`,`id`),
  KEY `centrosettimana_ibfk_1_idx` (`idsettimana`),
  CONSTRAINT `centrosettimana_ibfk_1` FOREIGN KEY (`idcentro`) REFERENCES `centro` (`idcentro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `centrosettimana_ibfk_2` FOREIGN KEY (`idsettimana`) REFERENCES `settimana` (`idSettimana`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centrosettimana`
--

LOCK TABLES `centrosettimana` WRITE;
/*!40000 ALTER TABLE `centrosettimana` DISABLE KEYS */;
INSERT INTO `centrosettimana` VALUES (2,1,70,1),(2,2,70,2),(2,3,70,3),(2,4,70,4),(2,5,70,5),(2,6,70,6),(3,1,50,7),(3,2,50,8),(3,3,50,9),(3,4,50,10),(3,5,50,11),(3,6,50,12);
/*!40000 ALTER TABLE `centrosettimana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizione`
--

DROP TABLE IF EXISTS `iscrizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iscrizione` (
  `idiscrizione` int NOT NULL AUTO_INCREMENT,
  `dataIscrizione` date NOT NULL,
  `qrCode` varchar(512) NOT NULL,
  `prezzo` float NOT NULL,
  `richiestaDisdetta` tinyint DEFAULT '0',
  `rimborsoDisdetta` float DEFAULT '0',
  `cfGenitore` varchar(16) NOT NULL,
  `cfBambino` varchar(16) NOT NULL,
  `tipoSoggiorno` varchar(100) NOT NULL,
  `servizioSportivo` tinyint NOT NULL DEFAULT '0',
  `pagata` tinyint DEFAULT '0',
  `idCentro` int NOT NULL,
  PRIMARY KEY (`idiscrizione`),
  KEY `cfBambino_idx` (`cfBambino`),
  KEY `cfGenitoreI_idx` (`cfGenitore`),
  KEY `idCentro_idx` (`idCentro`),
  CONSTRAINT `cfBambino` FOREIGN KEY (`cfBambino`) REFERENCES `bambino` (`codiceFiscale`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cfGenitoreI` FOREIGN KEY (`cfGenitore`) REFERENCES `utente` (`codiceFiscaleUtente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idCentro` FOREIGN KEY (`idCentro`) REFERENCES `centro` (`idcentro`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizione`
--

LOCK TABLES `iscrizione` WRITE;
/*!40000 ALTER TABLE `iscrizione` DISABLE KEYS */;
INSERT INTO `iscrizione` VALUES (3,'2021-02-17','MMM',150,0,0,'MRARSS00E02F123S','GNLRSS06R02C987S','FULL-TIME',0,0,2),(4,'2021-01-12','MMM',170,0,0,'SPSVCN04E09C321S','ANTCLM02E12R431A','FULL_TIME',0,0,2),(5,'2021-02-02','MMM',200,0,0,'DADANT22C05C234S','DDDPLC10A45D321A','PART-TIME',1,0,3),(6,'2021-02-20','QRCODE',220,0,0,'MRARSS00E02F123S','ZZPALF12D02C213S','Part-Time',1,0,2),(7,'2021-02-20','QRCODE',220,0,0,'MRARSS00E02F123S','ZZPALF12D02C213S','Part-Time',1,0,3),(8,'2022-05-27','QRCODE',70,0,0,'MRARSS00E02F123S','GNLRSS06R02C987S','Part-Time',1,0,2);
/*!40000 ALTER TABLE `iscrizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizionesettimana`
--

DROP TABLE IF EXISTS `iscrizionesettimana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iscrizionesettimana` (
  `idiscrizione` int NOT NULL,
  `idsettimana` int NOT NULL,
  PRIMARY KEY (`idiscrizione`,`idsettimana`),
  KEY `idsettimana` (`idsettimana`),
  CONSTRAINT `iscrizionesettimana_ibfk_1` FOREIGN KEY (`idiscrizione`) REFERENCES `iscrizione` (`idiscrizione`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `iscrizionesettimana_ibfk_2` FOREIGN KEY (`idsettimana`) REFERENCES `settimana` (`idSettimana`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizionesettimana`
--

LOCK TABLES `iscrizionesettimana` WRITE;
/*!40000 ALTER TABLE `iscrizionesettimana` DISABLE KEYS */;
INSERT INTO `iscrizionesettimana` VALUES (3,1),(5,1),(6,1),(7,1),(8,1),(3,2),(4,2),(4,3),(6,3),(7,3),(4,5),(5,5),(5,6);
/*!40000 ALTER TABLE `iscrizionesettimana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settimana`
--

DROP TABLE IF EXISTS `settimana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `settimana` (
  `dataInizio` date NOT NULL,
  `dataFine` date NOT NULL,
  `idSettimana` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idSettimana`),
  UNIQUE KEY `dataInizio_UNIQUE` (`dataInizio`),
  UNIQUE KEY `dataFine_UNIQUE` (`dataFine`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settimana`
--

LOCK TABLES `settimana` WRITE;
/*!40000 ALTER TABLE `settimana` DISABLE KEYS */;
INSERT INTO `settimana` VALUES ('2021-05-01','2021-05-07',1),('2021-06-01','2021-06-07',2),('2021-05-10','2021-05-16',3),('2021-07-01','2021-07-06',4),('2021-08-01','2021-08-06',5),('2021-09-01','2021-09-06',6);
/*!40000 ALTER TABLE `settimana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lastName` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Antonio','Bello');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `codiceFiscaleUtente` varchar(16) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dataNascita` date NOT NULL,
  `genere` char(1) NOT NULL,
  `ruolo` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `luogoNascita` varchar(255) DEFAULT NULL,
  `indirizzo` varchar(255) DEFAULT NULL,
  `citta` varchar(255) DEFAULT NULL,
  `cap` int DEFAULT NULL,
  `professione` varchar(255) DEFAULT NULL,
  `numTelefono` varchar(20) DEFAULT NULL,
  `numTelefonoSecondario` varchar(20) DEFAULT NULL,
  `documentoIdentita` varchar(512) DEFAULT NULL,
  `consensoInfo` tinyint DEFAULT '0',
  `consensoImgEVideo` tinyint DEFAULT '0',
  `delega` varchar(255) DEFAULT NULL,
  `infoFamiliari` varchar(512) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `provider` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`codiceFiscaleUtente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES ('DADANT22C05C234S','Antonio','Dalia','a.dalia@gmal.com','1998-09-12','M','genitore','Antonio123@','Nocera inferiore','Via concilio','Angri',84012,'Studente','0812345876',NULL,NULL,0,0,NULL,NULL,'Salerno',NULL),('DNNGRD12D05F456D','Gerardo','Donnarumma','gdonnarumma50@studenti.unisa.it','1999-05-04','M','genitore','Gerardo123.','Pagani','Via flaming','Angri',84012,'Studente','3512527871',NULL,NULL,0,0,NULL,NULL,'Salerno',NULL),('LDTCMN99B22F912T','Carmine','Laudato','c.laudato2@gmail.com','1999-02-22','M','responsabile','Mario123@','Nocera Inferiore','Via croce','Nocera Superiore',84015,'Responsabile','3405073613',NULL,NULL,1,1,NULL,NULL,NULL,NULL),('MRARSS00E02F123S','Mario','Rossi','m.rossi@gmail.com','1978-05-04','M','genitore','Mario123@','Napoli','Via roma','Napoli',84012,'Imprenditore','3913458731',NULL,NULL,1,1,NULL,NULL,'Napoli',NULL),('SPSVCN04E09C321S','Vincenzo','Esposito','v.esposito@gmail.com','2000-05-04','M','genitore','Vincenzo123@','Castellammare','Via annunzita','Angri',84012,'Studente','3339856871',NULL,NULL,0,0,NULL,NULL,'Salerno',NULL);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'summer_center'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14  8:28:58
