-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema watchCustom
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `watchCustom` ;

-- -----------------------------------------------------
-- Schema watchCustom
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `watchCustom` DEFAULT CHARACTER SET latin1 ;
SHOW WARNINGS;
USE `watchCustom` ;

-- -----------------------------------------------------
-- Table `watchCustom`.`client`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`client` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`client` (
  `client_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `street_no` INT(11) NOT NULL,
  `street_name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(45) NOT NULL,
  `gender` INT(11) NOT NULL,
  `phone_number` INT(11) NOT NULL,
  `clientcol` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`client_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `watchCustom`.`command`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`command` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`command` (
  `command_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_product_id` INT(11) NOT NULL,
  `fk_client_id` INT(11) NOT NULL,
  `amount` INT(11) NOT NULL,
  `status` INT(11) NOT NULL,
  PRIMARY KEY (`command_id`),
  INDEX `fk_client_id_idx` (`fk_client_id` ASC),
  CONSTRAINT `fk_client_id`
    FOREIGN KEY (`fk_client_id`)
    REFERENCES `watchCustom`.`client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `watchCustom`.`photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`photo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`photo` (
  `photo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `image` BLOB NOT NULL,
  PRIMARY KEY (`photo_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `watchCustom`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`product` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`product` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `price` INT(11) NOT NULL,
  `fk_product_image_id` INT(11) NOT NULL,
  `fk_vendor_id` INT(11) NOT NULL,
  `fk_statistic_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `title_UNIQUE` (`title` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `watchCustom`.`product_command`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`product_command` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`product_command` (
  `product_command_id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_fk_id` INT(11) NOT NULL,
  `command_fk_id` INT(11) NOT NULL,
  PRIMARY KEY (`product_command_id`),
  INDEX `fk_product_idx` (`product_fk_id` ASC),
  CONSTRAINT `fk_command`
    FOREIGN KEY (`product_fk_id`)
    REFERENCES `watchCustom`.`command` (`command_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product`
    FOREIGN KEY (`product_fk_id`)
    REFERENCES `watchCustom`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `watchCustom`.`product_photo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`product_photo` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`product_photo` (
  `product_photo_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fk_product_id` INT(11) NOT NULL,
  `fk_image_id` INT(11) NOT NULL,
  PRIMARY KEY (`product_photo_id`),
  INDEX `fk_product_photo_idx` (`fk_product_id` ASC),
  CONSTRAINT `fk_photo`
    FOREIGN KEY (`fk_product_id`)
    REFERENCES `watchCustom`.`photo` (`photo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product`
    FOREIGN KEY (`fk_product_id`)
    REFERENCES `watchCustom`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `watchCustom`.`record`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `watchCustom`.`record` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `watchCustom`.`record` (
  `record_id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `fk_client_id` INT(11) NOT NULL,
  PRIMARY KEY (`record_id`),
  INDEX `fk_record_1_idx` (`fk_client_id` ASC),
  CONSTRAINT `fk_client`
    FOREIGN KEY (`fk_client_id`)
    REFERENCES `watchCustom`.`client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
