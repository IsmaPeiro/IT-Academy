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
-- Table structure for table `channel`
--

DROP TABLE IF EXISTS `channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channel` (
  `channel_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `description` varchar(100) NOT NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY (`channel_id`),
  KEY `fk_channel_user1_idx` (`user_id`),
  CONSTRAINT `fk_channel_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `channel_has_video`
--

DROP TABLE IF EXISTS `channel_has_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `channel_has_video` (
  `channel_has_video_id` int NOT NULL AUTO_INCREMENT,
  `channel_id` int DEFAULT NULL,
  `video_id` int DEFAULT NULL,
  PRIMARY KEY (`channel_has_video_id`),
  KEY `fk_channel_has_video_video1_idx` (`video_id`),
  KEY `fk_channel_has_video_channel1_idx` (`channel_id`),
  CONSTRAINT `fk_channel_has_video_channel1` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`channel_id`),
  CONSTRAINT `fk_channel_has_video_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `channel_has_video_BEFORE_INSERT` BEFORE INSERT ON `channel_has_video` FOR EACH ROW BEGIN
	DECLARE duplicate_video INT;
    DECLARE video_owner_id INT;
    DECLARE channel_owner_id INT;
	DECLARE video_visibility ENUM ('public','private','hide');
	
    SELECT COUNT(channel_has_video_id) 
    INTO duplicate_video
    FROM channel_has_video
    WHERE channel_id=NEW.channel_id AND video_id=NEW.video_id;
    
    SELECT video.visibility
		INTO video_visibility
		FROM video
		WHERE video.video_id=NEW.video_id;
    
    SELECT video.user_id 
        INTO video_owner_id
        FROM video
        WHERE video_id=NEW.video_id;
    
    SELECT channel.user_id 
        INTO channel_owner_id
        FROM youtube.channel
        WHERE channel_id=NEW.channel_id;
    
    IF duplicate_video>0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video already exists in the channel';
    END IF;
    
    IF video_visibility != 'public' AND video_owner_id != channel_owner_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video must be public or you must be the owner';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `channel_has_video_BEFORE_UPDATE` BEFORE UPDATE ON `channel_has_video` FOR EACH ROW BEGIN
	DECLARE duplicate_video INT;
    DECLARE video_owner_id INT;
    DECLARE channel_owner_id INT;
	DECLARE video_visibility ENUM ('public','private','hide');
	
    SELECT COUNT(channel_has_video_id) 
    INTO duplicate_video
    FROM channel_has_video
    WHERE channel_id=NEW.channel_id AND video_id=NEW.video_id;
    
    SELECT video.visibility
		INTO video_visibility
		FROM video
		WHERE video.video_id=NEW.video_id;
    
    SELECT video.user_id 
        INTO video_owner_id
        FROM video
        WHERE video_id=NEW.video_id;
    
    SELECT channel.user_id 
        INTO channel_owner_id
        FROM youtube.channel
        WHERE channel_id=NEW.channel_id;
    
    IF duplicate_video>0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video already exists in the channel';
    END IF;
    
    IF video_visibility != 'public' AND video_owner_id != channel_owner_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video must be public or you must be the owner';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `video_id` int NOT NULL,
  `user_id` int NOT NULL,
  `text` varchar(300) NOT NULL,
  `creation_date` datetime NOT NULL,
  `likes` int NOT NULL DEFAULT '0',
  `dislikes` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`comment_id`),
  KEY `fk_comment_video1_idx` (`video_id`),
  KEY `fk_comment_user1_idx` (`user_id`),
  CONSTRAINT `fk_comment_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_comment_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comment_BEFORE_INSERT` BEFORE INSERT ON `comment` FOR EACH ROW BEGIN
	DECLARE video_owner_id INT;
	DECLARE video_visibility ENUM ('public','private','hide');
	
    SELECT video.visibility
		INTO video_visibility
		FROM video
		WHERE video.video_id=NEW.video_id;
    
    SELECT video.user_id 
        INTO video_owner_id
        FROM video
        WHERE video_id=NEW.video_id;
    
    IF video_visibility != 'public' AND video_owner_id != NEW.user_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video must be public or you must be the owner';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comment_BEFORE_UPDATE` BEFORE UPDATE ON `comment` FOR EACH ROW BEGIN
	DECLARE video_owner_id INT;
	DECLARE video_visibility ENUM ('public','private','hide');
	
    SELECT video.visibility
		INTO video_visibility
		FROM video
		WHERE video.video_id=NEW.video_id;
    
    SELECT video.user_id 
        INTO video_owner_id
        FROM video
        WHERE video_id=NEW.video_id;
    
    IF video_visibility != 'public' AND video_owner_id != NEW.user_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video must be public or you must be the owner';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comment_reaction`
--

DROP TABLE IF EXISTS `comment_reaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_reaction` (
  `reaction_id` int NOT NULL AUTO_INCREMENT,
  `comment_id` int NOT NULL,
  `user_id` int NOT NULL,
  `type` enum('like','dislike') NOT NULL,
  PRIMARY KEY (`reaction_id`),
  KEY `fk_reaction_user1_idx` (`user_id`),
  KEY `fk_reaction_video1_idx` (`comment_id`),
  CONSTRAINT `fk_comment_reaction_comment1` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`),
  CONSTRAINT `fk_reaction_user10` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_reaction_video10` FOREIGN KEY (`comment_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comment_reaction_BEFORE_INSERT` BEFORE INSERT ON `comment_reaction` FOR EACH ROW BEGIN
	DECLARE duplicate_reaction INT;
    SELECT COUNT(reaction_id)
    INTO duplicate_reaction
    FROM comment_reaction
    WHERE user_id = NEW.user_id AND comment_id= NEW.comment_id;
	IF  duplicate_reaction>0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The user has already reacted to the comment';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comment_reaction_AFTER_INSERT` AFTER INSERT ON `comment_reaction` FOR EACH ROW BEGIN
	DECLARE total_likes INT;    
    DECLARE total_dislikes INT;  
    
    SELECT COUNT(reaction_id)
        INTO total_likes
        FROM comment_reaction        
        WHERE comment_reaction.type='like' AND comment_reaction.comment_id=NEW.comment_id;
    
    SELECT COUNT(reaction_id)
        INTO total_dislikes
        FROM comment_reaction
        WHERE comment_reaction.type='dislike' AND comment_reaction.comment_id=NEW.comment_id;
    
    UPDATE comment
    SET likes=total_likes, dislikes=total_dislikes
	WHERE youtube.comment.comment_id=NEW.comment_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comment_reaction_AFTER_UPDATE` AFTER UPDATE ON `comment_reaction` FOR EACH ROW BEGIN
	DECLARE total_likes INT;    
    DECLARE total_dislikes INT;  
    
    SELECT COUNT(reaction_id)
        INTO total_likes
        FROM comment_reaction
        WHERE comment_reaction.type='like' AND comment_reaction.comment_id=NEW.comment_id;
    
    SELECT COUNT(reaction_id)
        INTO total_dislikes
        FROM comment_reaction
        WHERE comment_reaction.type='dislike' AND comment_reaction.comment_id=NEW.comment_id;
    
    UPDATE comment
    SET likes=total_likes, dislikes=total_dislikes
	WHERE youtube.comment.comment_id=NEW.comment_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `comment_reaction_AFTER_DELETE` AFTER DELETE ON `comment_reaction` FOR EACH ROW BEGIN
	DECLARE total_likes INT; 
    DECLARE total_dislikes INT;
    
    SELECT COUNT(reaction_id)
        INTO total_likes
        FROM comment_reaction
        WHERE comment_reaction.type='like' AND comment_reaction.comment_id=OLD.comment_id;
        
	SELECT COUNT(reaction_id)
        INTO total_dislikes
        FROM comment_reaction
        WHERE comment_reaction.type='dislike' AND comment_reaction.comment_id=OLD.comment_id;
   
   UPDATE comment
    SET likes=total_likes, dislikes=total_dislikes
	WHERE youtube.comment.comment_id=OLD.comment_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlist_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `creation_date` datetime NOT NULL,
  `state` enum('public','private') NOT NULL,
  PRIMARY KEY (`playlist_id`),
  KEY `fk_playlist_user1_idx` (`user_id`),
  CONSTRAINT `fk_playlist_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `playlist_has_video`
--

DROP TABLE IF EXISTS `playlist_has_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist_has_video` (
  `playlist_has_video_id` int NOT NULL AUTO_INCREMENT,
  `playlist_id` int NOT NULL,
  `video_id` int NOT NULL,
  PRIMARY KEY (`playlist_has_video_id`),
  KEY `fk_playlist_has_video_video1_idx` (`video_id`),
  KEY `fk_playlist_has_video_playlist1_idx` (`playlist_id`),
  CONSTRAINT `fk_playlist_has_video_playlist1` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`playlist_id`),
  CONSTRAINT `fk_playlist_has_video_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `playlist_has_video_BEFORE_INSERT` BEFORE INSERT ON `playlist_has_video` FOR EACH ROW BEGIN
	DECLARE duplicate_video INT;
    DECLARE video_owner_id INT;
    DECLARE playlist_owner_id INT;
	DECLARE video_visibility ENUM ('public','private','hide');
	
    SELECT COUNT(playlist_has_video_id)
    INTO duplicate_video
    FROM playlist_has_video
    WHERE playlist_id=NEW.playlist_id AND video_id=NEW.video_id;
    
    SELECT video.visibility
		INTO video_visibility
		FROM video
		WHERE video.video_id=NEW.video_id;
    
    SELECT video.user_id 
        INTO video_owner_id
        FROM video
        WHERE video_id=NEW.video_id;
    
    SELECT playlist.user_id 
        INTO playlist_owner_id
        FROM playlist
        WHERE playlist_id=NEW.playlist_id;
    
    IF duplicate_video>0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video is already in the playlist';
    END IF;
    
    IF video_visibility != 'public' AND video_owner_id != playlist_owner_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video must be public or you must be the owner';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `playlist_has_video_BEFORE_UPDATE` BEFORE UPDATE ON `playlist_has_video` FOR EACH ROW BEGIN
	DECLARE duplicate_video INT;
    DECLARE video_owner_id INT;
    DECLARE playlist_owner_id INT;
	DECLARE video_visibility ENUM ('public','private','hide');
	
	SELECT COUNT(playlist_has_video_id)
    INTO duplicate_video
    FROM playlist_has_video
    WHERE playlist_id=NEW.playlist_id AND video_id=NEW.video_id;
    
    SELECT video.visibility
		INTO video_visibility
		FROM video
		WHERE video.video_id=NEW.video_id;
    
    SELECT video.user_id 
        INTO video_owner_id
        FROM video
        WHERE video_id=NEW.video_id;
    
    SELECT playlist.user_id 
        INTO playlist_owner_id
        FROM playlist.user_id
        WHERE playlist_id=NEW.playlist_id;
    
    IF duplicate_video>0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video is already in the playlist';
    END IF;
    
    IF video_visibility != 'public' AND video_owner_id != playlist_owner_id THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'The video must be public or you must be the owner';
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `subscription_id` int NOT NULL AUTO_INCREMENT,
  `channel_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`subscription_id`),
  KEY `fk_subscription_channel1_idx` (`channel_id`),
  KEY `fk_subscription_user1_idx` (`user_id`),
  CONSTRAINT `fk_subscription_channel1` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`channel_id`),
  CONSTRAINT `fk_subscription_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `subscription_BEFORE_INSERT` BEFORE INSERT ON `subscription` FOR EACH ROW BEGIN
	DECLARE duplicate_subscription INT;
    SELECT COUNT(subscription_id)
    INTO duplicate_subscription
    FROM subscription
    WHERE user_id = NEW.user_id AND channel_id= NEW.channel_id;
	IF  duplicate_subscription>0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The user is already subscribed to the channel';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `subscription_BEFORE_UPDATE` BEFORE UPDATE ON `subscription` FOR EACH ROW BEGIN
	DECLARE duplicate_subscription INT;
    SELECT COUNT(subscription_id)
    INTO duplicate_subscription
    FROM subscription
    WHERE user_id = NEW.user_id AND channel_id= NEW.channel_id;
	IF  duplicate_subscription>0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The user is already subscribed to the channel';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `tag_id` int NOT NULL AUTO_INCREMENT,
  `video_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`tag_id`),
  KEY `fk_tag_video1_idx` (`video_id`),
  CONSTRAINT `fk_tag_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `bird_date` date NOT NULL,
  `sex` enum('woman','man','nonbinary') NOT NULL,
  `country` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video` (
  `video_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `publication_date` datetime NOT NULL,
  `tittle` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `visibility` enum('public','hide','private') NOT NULL,
  `size` float NOT NULL,
  `file_name` varchar(45) NOT NULL,
  `thumbnail` varchar(45) NOT NULL,
  `views` int NOT NULL DEFAULT '0',
  `likes` int NOT NULL DEFAULT '0',
  `dislikes` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`video_id`),
  KEY `fk_video_user_idx` (`user_id`),
  CONSTRAINT `fk_video_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `video_reaction`
--

DROP TABLE IF EXISTS `video_reaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video_reaction` (
  `reaction_id` int NOT NULL AUTO_INCREMENT,
  `video_id` int NOT NULL,
  `user_id` int NOT NULL,
  `type` enum('like','dislike') NOT NULL,
  PRIMARY KEY (`reaction_id`),
  KEY `fk_video_reaction_video1_idx` (`video_id`),
  KEY `fk_video_reaction_user1_idx` (`user_id`),
  CONSTRAINT `fk_video_reaction_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_video_reaction_video1` FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `video_reaction_BEFORE_INSERT` BEFORE INSERT ON `video_reaction` FOR EACH ROW BEGIN
	DECLARE duplicate_reaction INT;
    SELECT COUNT(reaction_id)
    INTO duplicate_reaction
    FROM video_reaction
    WHERE user_id = NEW.user_id AND video_id= NEW.video_id;
	IF  duplicate_reaction>0 THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'The user is already reacted to the video';
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `video_reaction_AFTER_INSERT` AFTER INSERT ON `video_reaction` FOR EACH ROW BEGIN
	DECLARE total_likes INT;   
    DECLARE total_dislikes INT;  
        
    SELECT COUNT(reaction_id)
        INTO total_likes
        FROM video_reaction
        WHERE video_reaction.type='like' AND video_reaction.video_id=NEW.video_id;
	 
     SELECT COUNT(reaction_id)
        INTO total_dislikes
        FROM video_reaction
        WHERE video_reaction.type='dislike' AND video_reaction.video_id=NEW.video_id;
    
    UPDATE video
    SET likes=total_likes, dislikes=total_dislikes
	WHERE video.video_id=NEW.video_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `video_reaction_AFTER_UPDATE` AFTER UPDATE ON `video_reaction` FOR EACH ROW BEGIN
	DECLARE total_likes INT;   
    DECLARE total_dislikes INT;  
       
    SELECT COUNT(reaction_id)
        INTO total_likes
        FROM video_reaction
        WHERE video_reaction.type='like' AND video_reaction.video_id=NEW.video_id;
     
     SELECT COUNT(reaction_id)
        INTO total_dislikes
        FROM video_reaction
        WHERE video_reaction.type='dislike' AND video_reaction.video_id=NEW.video_id;
    
    UPDATE video
    SET likes=total_likes, dislikes=total_dislikes
	WHERE video.video_id=NEW.video_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `video_reaction_AFTER_DELETE` AFTER DELETE ON `video_reaction` FOR EACH ROW BEGIN
	DECLARE total_likes INT;   
    DECLARE total_dislikes INT;  
    
    SELECT COUNT(reaction_id)
        INTO total_likes
        FROM video_reaction
        WHERE video_reaction.type='like' AND video_reaction.video_id=OLD.video_id;
    
    SELECT COUNT(reaction_id)
        INTO total_dislikes
        FROM video_reaction
        WHERE video_reaction.type='dislike' AND video_reaction.video_id=OLD.video_id;
   
   UPDATE video
    SET likes=total_likes, dislikes=total_dislikes
	WHERE video.video_id=OLD.video_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'youtube'
--

--
-- Dumping routines for database 'youtube'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-08 19:22:09
