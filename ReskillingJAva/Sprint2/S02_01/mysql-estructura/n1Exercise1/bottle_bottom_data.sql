-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bottle_bottom
-- ------------------------------------------------------
-- Server version	8.0.37
USE bottle_bottom;

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
-- Dumping data for table `adress`
--

LOCK TABLES `adress` WRITE;
/*!40000 ALTER TABLE `adress` DISABLE KEYS */;
INSERT INTO `adress` VALUES (1,'Main Street','1',NULL,NULL,'London','10001','UK'),(2,'Oak Avenue','20','3','A','Toronto','90001','Canada'),(3,'Pine Road','15',NULL,NULL,'London','60601','UK'),(4,'Elm Boulevard','50',NULL,NULL,'Sydney','77001','Australia'),(5,'Maple Lane','8','2','B','Paris','33101','France'),(6,'Cedar Street','30',NULL,NULL,'Berlin','75201','Germany'),(7,'River Road','25','1','C','Tokyo','85001','Japan'),(8,'Forest Avenue','40',NULL,NULL,'Madrid','92101','Spain'),(9,'Sunset Drive','5',NULL,NULL,'Rome','78201','Italy'),(10,'Sunrise Court','12','4','D','Rio de Janeiro','94101','Brazil'),(11,'Ocean View','18',NULL,NULL,'Mexico City','98101','Mexico'),(12,'Lake Road','22','2','E','Seoul','02101','South Korea'),(13,'Mountain Street','7',NULL,NULL,'Delhi','19101','India'),(14,'Valley Drive','35',NULL,NULL,'Beijing','20001','China'),(15,'Hillside Avenue','11','3','F','Moscow','80201','Russia'),(16,'Ridge Lane','28',NULL,NULL,'Cape Town','89101','South Africa'),(17,'Park Place','14',NULL,NULL,'Buenos Aires','30301','Argentina'),(18,'Grove Street','9','1','G','Santiago','97201','Chile'),(19,'Meadow Drive','16',NULL,NULL,'Wellington','78701','New Zealand'),(20,'Field Road','3',NULL,NULL,'Amsterdam','95101','Netherlands'),(21,'Supplier Avenue','10',NULL,NULL,'Oslo','11111','Norway'),(22,'Distributor Lane','5',NULL,NULL,'Stockholm','22222','Sweden'),(23,'Vendor Road','20','2','B','Zurich','33333','Switzerland'),(24,'Supplier Street','15',NULL,NULL,'Brussels','44444','Belgium'),(25,'Eyewear Drive','8',NULL,NULL,'Vienna','55555','Austria'),(26,'Bridge Street','1',NULL,NULL,'Helsinki','10001','Finland');
/*!40000 ALTER TABLE `adress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,1,1,1,'2024-01-01 10:00:00'),(2,2,2,2,'2023-03-08 11:00:00'),(3,3,3,3,'2023-06-13 12:00:00'),(4,4,4,4,'2023-02-14 13:00:00'),(5,5,5,1,'2022-08-06 14:00:00'),(6,6,6,2,'2023-10-20 15:00:00'),(7,7,7,3,'2021-11-13 16:00:00'),(8,8,8,4,'2023-12-19 17:00:00'),(9,9,9,1,'2023-04-12 18:00:00'),(10,10,10,2,'2024-05-10 19:00:00'),(11,11,11,3,'2023-05-16 20:00:00'),(12,12,12,4,'2022-06-14 21:00:00'),(13,13,13,1,'2019-03-03 22:00:00'),(14,14,14,2,'2023-07-25 23:00:00'),(15,15,15,3,'2018-01-19 09:00:00'),(16,16,1,4,'2023-08-06 08:00:00'),(17,17,2,1,'2017-05-19 07:00:00'),(18,18,3,2,'2016-03-26 06:00:00'),(19,19,4,3,'2015-07-30 05:00:00'),(20,20,5,4,'2023-09-15 04:00:00');
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (1,'Fashion Frames','123456789'),(2,'Visionary Eyewear','987654321'),(3,'Chic Shades','111222333'),(4,'Sun Seeker','444555666'),(5,'Crystal Clear','777888999');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'John Doe','1234567890','john.doe@example.com','2020-01-15 08:30:00',NULL,1),(2,'Jane Smith','9876543210','jane.smith@example.com','2019-02-20 10:15:00',1,2),(3,'Michael Johnson','5556667777','michael.johnson@example.com','2021-03-10 14:45:00',NULL,3),(4,'Emily Brown','3334445555','emily.brown@example.com','2018-04-05 11:00:00',2,4),(5,'William Wilson','9998887777','william.wilson@example.com','2019-05-12 09:30:00',3,5),(6,'Sophia Garcia','1112223333','sophia.garcia@example.com','2020-06-18 13:45:00',NULL,6),(7,'Oliver Martinez','4445556666','oliver.martinez@example.com','2017-07-22 16:00:00',4,7),(8,'Isabella Lopez','7778889999','isabella.lopez@example.com','2020-08-30 09:00:00',NULL,8),(9,'Ethan Robinson','6667778888','ethan.robinson@example.com','2019-09-25 12:30:00',5,9),(10,'Ava Wilson','2223334444','ava.wilson@example.com','2020-06-30 12:00:00',6,10),(11,'James Lee','8889990000','james.lee@example.com','2021-11-09 17:45:00',NULL,11),(12,'Mia Moore','5554443333','mia.moore@example.com','2020-12-04 10:00:00',7,12),(13,'Alexander Brown','3332221111','alexander.brown@example.com','2018-01-02 14:00:00',NULL,13),(14,'Charlotte White','9990001111','charlotte.white@example.com','2019-02-15 08:45:00',8,14),(15,'Liam Hall','6660001111','liam.hall@example.com','2020-03-20 11:30:00',NULL,15),(16,'Amelia Clark','1112223333','amelia.clark@example.com','2021-04-25 13:00:00',9,16),(17,'Benjamin Turner','7778889999','benjamin.turner@example.com','2022-05-12 16:15:00',NULL,17),(18,'Chloe Harris','4445556666','chloe.harris@example.com','2021-06-18 09:45:00',10,18),(19,'Daniel Hill','2223334444','daniel.hill@example.com','2019-07-22 12:30:00',NULL,19),(20,'Grace Walker','8889990000','grace.walker@example.com','2018-08-30 15:00:00',11,20);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Alice Johnson'),(2,'Bob Smith'),(3,'Carol White'),(4,'David Brown');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `glasses`
--

LOCK TABLES `glasses` WRITE;
/*!40000 ALTER TABLE `glasses` DISABLE KEYS */;
INSERT INTO `glasses` VALUES (1,1,1.00,1.25,'Black','Blue','Green','100.00'),(2,2,1.25,1.50,'Brown','Red','Yellow','120.00'),(3,3,0.75,1.00,'Silver','Pink','Purple','80.00'),(4,4,1.25,1.00,'Gold','Orange','Blue','150.00'),(5,5,1.50,1.25,'Rose Gold','Purple','Silver','130.00'),(6,1,0.75,1.00,'Matte Black','Yellow','Red','90.00'),(7,2,1.00,1.25,'Tortoise Shell','Green','Brown','110.00'),(8,3,1.25,1.50,'Transparent','Blue','Pink','95.00'),(9,4,1.00,1.25,'Pearl White','Purple','Gold','140.00'),(10,5,1.25,1.50,'Gradient Blue','Silver','Black','125.00'),(11,1,1.50,1.75,'Black','Blue','Green','100.00'),(12,2,1.75,1.50,'Brown','Red','Yellow','120.00'),(13,3,1.00,1.25,'Silver','Pink','Purple','80.00'),(14,4,1.75,1.50,'Gold','Orange','Blue','150.00'),(15,5,1.50,1.25,'Rose Gold','Purple','Silver','130.00'),(16,1,1.00,1.25,'Matte Black','Yellow','Red','90.00'),(17,2,1.25,1.50,'Tortoise Shell','Green','Brown','110.00'),(18,3,1.50,1.75,'Transparent','Blue','Pink','95.00'),(19,4,1.25,1.50,'Pearl White','Purple','Gold','140.00'),(20,5,1.50,1.75,'Gradient Blue','Silver','Black','125.00');
/*!40000 ALTER TABLE `glasses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('111222333','Vision Direct','8889990000',NULL,21),('123456789','ABC Eyewear Suppliers','1112223333','4445556666',22),('444555666','SunGlasses Ltd','5556667777',NULL,23),('777888999','Smart Vision Inc','3334445555','2223334444',24),('987654321','XYZ Optical Distributors','7778889999',NULL,25);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-02 18:30:22
