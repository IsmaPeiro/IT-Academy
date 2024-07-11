CREATE DATABASE  IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `youtube`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: youtube
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Dumping data for table `channel`
--

LOCK TABLES `channel` WRITE;
/*!40000 ALTER TABLE `channel` DISABLE KEYS */;
INSERT INTO `channel` VALUES (1,1,'Tech Reviews','2023-01-01 10:00:00'),(2,2,'Cooking Tips','2023-02-01 11:00:00'),(3,3,'Travel Vlogs','2023-03-01 12:00:00');
/*!40000 ALTER TABLE `channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `channel_has_video`
--

LOCK TABLES `channel_has_video` WRITE;
/*!40000 ALTER TABLE `channel_has_video` DISABLE KEYS */;
INSERT INTO `channel_has_video` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `channel_has_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,2,'Great review! Very helpful.','2023-01-03 10:30:00',1,0),(2,2,3,'I tried this recipe and it was amazing!','2023-02-04 11:30:00',1,0),(3,3,1,'Japan looks beautiful! Thanks for sharing.','2023-03-05 12:30:00',0,1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment_reaction`
--

LOCK TABLES `comment_reaction` WRITE;
/*!40000 ALTER TABLE `comment_reaction` DISABLE KEYS */;
INSERT INTO `comment_reaction` VALUES (1,1,1,'like'),(2,2,1,'like'),(3,3,2,'dislike');
/*!40000 ALTER TABLE `comment_reaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,1,'My Favorite Tech Reviews','2023-01-05 10:00:00','public'),(2,2,'Cooking Recipes','2023-02-05 11:00:00','private'),(3,3,'Travel Videos','2023-03-05 12:00:00','public');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `playlist_has_video`
--

LOCK TABLES `playlist_has_video` WRITE;
/*!40000 ALTER TABLE `playlist_has_video` DISABLE KEYS */;
INSERT INTO `playlist_has_video` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `playlist_has_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,1,3),(2,2,1),(3,3,2);
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,1,'tech'),(2,2,'cooking'),(3,3,'travel');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1@example.com','password1','1990-01-01','man','USA','10001'),(2,'user2@example.com','password2','1985-05-15','woman','Canada','M5V3L9'),(3,'user3@example.com','password3','2000-12-20','nonbinary','UK','WC2N5DU');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,1,'2023-01-02 10:00:00','Review of the Latest Smartphone','In-depth review of the latest smartphone model.','public',500.5,'smartphone_review.mp4','thumbnail1.jpg',1000,1,0),(2,2,'2023-02-03 11:00:00','How to Make Pancakes','Step-by-step guide to making delicious pancakes.','public',200.3,'pancakes.mp4','thumbnail2.jpg',2000,1,0),(3,3,'2023-03-04 12:00:00','Traveling to Japan','My experiences traveling through Japan.','public',300.7,'japan_travel.mp4','thumbnail3.jpg',1500,0,1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `video_reaction`
--

LOCK TABLES `video_reaction` WRITE;
/*!40000 ALTER TABLE `video_reaction` DISABLE KEYS */;
INSERT INTO `video_reaction` VALUES (1,1,2,'like'),(2,2,3,'like'),(3,3,1,'dislike');
/*!40000 ALTER TABLE `video_reaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 18:53:25
