-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema spotify
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spotify` ;

-- -----------------------------------------------------
-- Schema spotify
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spotify` DEFAULT CHARACTER SET utf8 ;
USE `spotify` ;

-- -----------------------------------------------------
-- Table `spotify`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`user` ;

CREATE TABLE IF NOT EXISTS `spotify`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `mail` VARCHAR(100) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `birth_date` DATE NOT NULL,
  `sex` ENUM('man', 'woman', 'nonbinary') NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(45) NOT NULL,
  `user_type` ENUM('free', 'premium') NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC) VISIBLE,
  UNIQUE INDEX `mail_UNIQUE` (`mail` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`subscription`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`subscription` ;

CREATE TABLE IF NOT EXISTS `spotify`.`subscription` (
  `subscription_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `start_date` DATE NOT NULL,
  `renovation_date` DATE NOT NULL,
  `pay_method` ENUM('credit_card', 'paypal') NOT NULL,
  PRIMARY KEY (`subscription_id`),
  INDEX `fk_subscription_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_subscription_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`credit_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`credit_card` ;

CREATE TABLE IF NOT EXISTS `spotify`.`credit_card` (
  `credit_card_id` INT NOT NULL AUTO_INCREMENT,
  `subscription_id` INT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  `expiration_month` INT NOT NULL,
  `expiration_year` INT NOT NULL,
  `ccv` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`credit_card_id`),
  INDEX `fk_credit_card_subscription1_idx` (`subscription_id` ASC) VISIBLE,
  CONSTRAINT `fk_credit_card_subscription1`
    FOREIGN KEY (`subscription_id`)
    REFERENCES `spotify`.`subscription` (`subscription_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`paypal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`paypal` ;

CREATE TABLE IF NOT EXISTS `spotify`.`paypal` (
  `paypal_id` INT NOT NULL AUTO_INCREMENT,
  `subscription_id` INT NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`paypal_id`),
  INDEX `fk_paypal_subscription1_idx` (`subscription_id` ASC) VISIBLE,
  CONSTRAINT `fk_paypal_subscription1`
    FOREIGN KEY (`subscription_id`)
    REFERENCES `spotify`.`subscription` (`subscription_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`payment` ;

CREATE TABLE IF NOT EXISTS `spotify`.`payment` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `order_number` INT NOT NULL,
  `total` FLOAT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`payment_id`),
  UNIQUE INDEX `order_number_UNIQUE` (`order_number` ASC) VISIBLE,
  INDEX `fk_payment_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_payment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`playlist` ;

CREATE TABLE IF NOT EXISTS `spotify`.`playlist` (
  `playlist_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `tittle` VARCHAR(45) NOT NULL,
  `songs_number` INT NOT NULL DEFAULT 0,
  `creation_date` DATE NOT NULL,
  `deleted` TINYINT NOT NULL DEFAULT 0,
  `deleted_date` DATE NULL,
  PRIMARY KEY (`playlist_id`),
  INDEX `fk_playlist_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_playlist_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`shared_with`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`shared_with` ;

CREATE TABLE IF NOT EXISTS `spotify`.`shared_with` (
  `playlist_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`playlist_id`, `user_id`),
  INDEX `shared_with_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `shared_with_playlist1_idx` (`playlist_id` ASC) VISIBLE,
  CONSTRAINT `shared_with_playlist1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `spotify`.`playlist` (`playlist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `shared_with_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`artist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`artist` ;

CREATE TABLE IF NOT EXISTS `spotify`.`artist` (
  `artist_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `image` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`artist_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`album` ;

CREATE TABLE IF NOT EXISTS `spotify`.`album` (
  `album_id` INT NOT NULL AUTO_INCREMENT,
  `artist_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `year` INT NOT NULL,
  `image` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`album_id`),
  INDEX `fk_album_artist1_idx` (`artist_id` ASC) VISIBLE,
  CONSTRAINT `fk_album_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `spotify`.`artist` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`song`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`song` ;

CREATE TABLE IF NOT EXISTS `spotify`.`song` (
  `song_id` INT NOT NULL AUTO_INCREMENT,
  `album_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `duration` INT NOT NULL,
  `plays_number` BIGINT NOT NULL,
  PRIMARY KEY (`song_id`),
  INDEX `fk_song_album1_idx` (`album_id` ASC) VISIBLE,
  CONSTRAINT `fk_song_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `spotify`.`album` (`album_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`playlist_has_song`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`playlist_has_song` ;

CREATE TABLE IF NOT EXISTS `spotify`.`playlist_has_song` (
  `playlist_id` INT NOT NULL,
  `song_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`playlist_id`, `song_id`),
  INDEX `fk_playlist_has_song_song1_idx` (`song_id` ASC) VISIBLE,
  INDEX `fk_playlist_has_song_playlist1_idx` (`playlist_id` ASC) VISIBLE,
  INDEX `fk_playlist_has_song_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_playlist_has_song_playlist1`
    FOREIGN KEY (`playlist_id`)
    REFERENCES `spotify`.`playlist` (`playlist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_has_song_song1`
    FOREIGN KEY (`song_id`)
    REFERENCES `spotify`.`song` (`song_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_has_song_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`favorite_album`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`favorite_album` ;

CREATE TABLE IF NOT EXISTS `spotify`.`favorite_album` (
  `user_id` INT NOT NULL,
  `album_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `album_id`),
  INDEX `fk_favorite_album_album1_idx` (`album_id` ASC) VISIBLE,
  CONSTRAINT `fk_favorite_album_album1`
    FOREIGN KEY (`album_id`)
    REFERENCES `spotify`.`album` (`album_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_favorite_album_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`favorite_song`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`favorite_song` ;

CREATE TABLE IF NOT EXISTS `spotify`.`favorite_song` (
  `user_id` INT NOT NULL,
  `song_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `song_id`),
  INDEX `fk_favorite_song_song1_idx` (`song_id` ASC) VISIBLE,
  CONSTRAINT `fk_favorite_song_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_favorite_song_song1`
    FOREIGN KEY (`song_id`)
    REFERENCES `spotify`.`song` (`song_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`following`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`following` ;

CREATE TABLE IF NOT EXISTS `spotify`.`following` (
  `user_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `artist_id`),
  INDEX `following_artist1_idx` (`artist_id` ASC) VISIBLE,
  INDEX `following_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `following_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `spotify`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `following_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `spotify`.`artist` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spotify`.`related_with`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spotify`.`related_with` ;

CREATE TABLE IF NOT EXISTS `spotify`.`related_with` (
  `artist_id` INT NOT NULL,
  `related_artist_id` INT NOT NULL,
  PRIMARY KEY (`artist_id`, `related_artist_id`),
  INDEX `related_with_artist2_idx` (`related_artist_id` ASC) VISIBLE,
  INDEX `related_with_artist1_idx` (`artist_id` ASC) VISIBLE,
  CONSTRAINT `related_with_artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `spotify`.`artist` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `related_with_artist2`
    FOREIGN KEY (`related_artist_id`)
    REFERENCES `spotify`.`artist` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `spotify`;

DELIMITER $$

USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`subscription_BEFORE_INSERT` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`subscription_BEFORE_INSERT` BEFORE INSERT ON `subscription` FOR EACH ROW
BEGIN
	DECLARE duplicate_subscription INT;
   
    SELECT COUNT(subscription_id) 
    INTO duplicate_subscription
    FROM subscription
    WHERE user_id=NEW.user_id;
         
    IF duplicate_subscription>0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the user already has a subscription';
    END IF;     
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`subscription_AFTER_INSERT` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`subscription_AFTER_INSERT` AFTER INSERT ON `subscription` FOR EACH ROW
BEGIN
	DECLARE user_type_var ENUM ('free','premium');
   
    SELECT user_type
    INTO user_type_var
    FROM spotify.user
    WHERE user_id=NEW.user_id;
         
    IF user_type_var='free' THEN
		UPDATE spotify.user
        SET user_type='premium'
        WHERE user_id=NEW.user_id;
    END IF;     
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`subscription_BEFORE_UPDATE` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`subscription_BEFORE_UPDATE` BEFORE UPDATE ON `subscription` FOR EACH ROW
BEGIN
	DECLARE duplicate_subscription INT;
   
    SELECT COUNT(subscription_id) 
    INTO duplicate_subscription
    FROM subscription
    WHERE user_id=NEW.user_id;
         
    IF duplicate_subscription>0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the user already has a subscription';
    END IF;     
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`subscription_AFTER_UPDATE` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`subscription_AFTER_UPDATE` AFTER UPDATE ON `subscription` FOR EACH ROW
BEGIN
	DECLARE user_type_var ENUM ('free','premium');
   
    SELECT user_type
    INTO user_type_var
    FROM spotify.user
    WHERE user_id=NEW.user_id;
         
    IF user_type_var='free' THEN
		UPDATE spotify.user
        SET user_type='premium'
        WHERE user_id=NEW.user_id;
    END IF;     
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`shared_with_BEFORE_INSERT` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`shared_with_BEFORE_INSERT` BEFORE INSERT ON `shared_with` FOR EACH ROW
BEGIN
	IF (
		SELECT deleted 
        FROM playlist
        WHERE playlist_id=NEW.playlist_id
        )>0
        THEN 
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the playlist is deleted';
	END IF;
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`shared_with_BEFORE_UPDATE` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`shared_with_BEFORE_UPDATE` BEFORE UPDATE ON `shared_with` FOR EACH ROW
BEGIN
	IF (
		SELECT deleted 
        FROM playlist
        WHERE playlist_id=NEW.playlist_id
        )>0
        THEN 
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the playlist is deleted';
	END IF;
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`playlist_has_song_BEFORE_INSERT` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`playlist_has_song_BEFORE_INSERT` BEFORE INSERT ON `playlist_has_song` FOR EACH ROW
BEGIN
	IF NOT EXISTS (
		SELECT 1
        FROM shared_with
        WHERE playlist_id=NEW.playlist_id AND user_id=NEW.user_id
        ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the playlist is not shared with user';
    END IF; 
    IF (
		SELECT COUNT(song_id) 
        FROM playlist_has_song
        WHERE playlist_id=NEW.playlist_id AND song_id=NEW.song_id
        )>0
        THEN 
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the song already exists in the playlist';
	END IF;
    IF (
		SELECT deleted 
        FROM playlist
        WHERE playlist_id=NEW.playlist_id
        )>0
        THEN 
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the playlist is deleted';
	END IF;
END$$


USE `spotify`$$
DROP TRIGGER IF EXISTS `spotify`.`playlist_has_song_BEFORE_UPDATE` $$
USE `spotify`$$
CREATE DEFINER = CURRENT_USER TRIGGER `spotify`.`playlist_has_song_BEFORE_UPDATE` BEFORE UPDATE ON `playlist_has_song` FOR EACH ROW
BEGIN
	IF NOT EXISTS (
		SELECT 1
        FROM shared_with
        WHERE playlist_id=NEW.playlist_id AND user_id=NEW.user_id
        ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the playlist is not shared with user';
    END IF; 
    IF (
		SELECT COUNT(song_id) 
        FROM playlist_has_song
        WHERE playlist_id=NEW.playlist_id AND song_id=NEW.song_id
        )>0
        THEN 
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'the song already exists in the playlist';
	END IF;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
