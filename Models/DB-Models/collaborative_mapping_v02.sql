-- MySQL Script generated by MySQL Workbench
-- 11/19/14 09:57:05
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema collaborative_mapping
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema collaborative_mapping
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `collaborative_mapping` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `collaborative_mapping` ;

-- -----------------------------------------------------
-- Table `collaborative_mapping`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(100) NULL,
  `CPF` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `institution` VARCHAR(100) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`who`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`who` (
  `idWho` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  PRIMARY KEY (`idWho`, `idUser`),
  INDEX `idUser_idx` (`idUser` ASC),
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `collaborative_mapping`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`when`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`when` (
  `idWhen` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `time` TIME NULL,
  PRIMARY KEY (`idWhen`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`what`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`what` (
  `idWhat` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`idWhat`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`where`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`where` (
  `idWhere` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idWhere`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`how`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`how` (
  `idHow` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(250) NULL,
  PRIMARY KEY (`idHow`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`rationale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`rationale` (
  `idRationale` INT NOT NULL AUTO_INCREMENT,
  `idWho` INT NOT NULL,
  `idWhat` INT NOT NULL,
  `idWhen` INT NOT NULL,
  `idWhere` INT NOT NULL,
  `idHow` INT NOT NULL,
  `idNewRationale` INT NULL,
  PRIMARY KEY (`idRationale`, `idWho`, `idWhat`, `idWhen`, `idWhere`, `idHow`),
  INDEX `idWho_idx` (`idWho` ASC),
  INDEX `idHow_idx` (`idHow` ASC),
  INDEX `idWhere_idx` (`idWhere` ASC),
  INDEX `idWhat_idx` (`idWhat` ASC),
  INDEX `idWhen_idx` (`idWhen` ASC),
  CONSTRAINT `idWho`
    FOREIGN KEY (`idWho`)
    REFERENCES `collaborative_mapping`.`who` (`idWho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idWhen`
    FOREIGN KEY (`idWhen`)
    REFERENCES `collaborative_mapping`.`when` (`idWhen`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idWhat`
    FOREIGN KEY (`idWhat`)
    REFERENCES `collaborative_mapping`.`what` (`idWhat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idWhere`
    FOREIGN KEY (`idWhere`)
    REFERENCES `collaborative_mapping`.`where` (`idWhere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idHow`
    FOREIGN KEY (`idHow`)
    REFERENCES `collaborative_mapping`.`how` (`idHow`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`communication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`communication` (
  `idCommunication` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(250) NULL,
  `idRationale` INT NOT NULL,
  `idUserReceptor` INT NOT NULL,
  `idUserIssuing` INT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  `read` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idCommunication`, `idRationale`, `idUserReceptor`),
  INDEX `idUserReceptor_idx` (`idUserReceptor` ASC),
  INDEX `idRationale_idx` (`idRationale` ASC),
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUserReceptor`)
    REFERENCES `collaborative_mapping`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idRationale`
    FOREIGN KEY (`idRationale`)
    REFERENCES `collaborative_mapping`.`rationale` (`idRationale`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`document` (
  `idDocument` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDocument`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`mappingFile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`mappingFile` (
  `idMappingFile` INT NOT NULL AUTO_INCREMENT,
  `idDocument1` INT NOT NULL,
  `idDocument2` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idMappingFile`),
  INDEX `idDocument_idx` (`idDocument1` ASC, `idDocument2` ASC),
  CONSTRAINT `idDocument`
    FOREIGN KEY (`idDocument1`)
    REFERENCES `collaborative_mapping`.`document` (`idDocument`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idDocument`
    FOREIGN KEY (`idDocument2`)
    REFERENCES `collaborative_mapping`.`document` (`idDocument`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`artefactsUsed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`artefactsUsed` (
  `idArtefact` INT NOT NULL,
  `idWhere` INT NOT NULL,
  PRIMARY KEY (`idArtefact`, `idWhere`),
  INDEX `idWhere_idx` (`idWhere` ASC),
  CONSTRAINT `idWhere`
    FOREIGN KEY (`idWhere`)
    REFERENCES `collaborative_mapping`.`where` (`idWhere`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idArtefact`
    FOREIGN KEY (`idArtefact`)
    REFERENCES `collaborative_mapping`.`mappingFile` (`idMappingFile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `collaborative_mapping`.`pairMap`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `collaborative_mapping`.`pairMap` (
  `idPairMap` INT NOT NULL,
  `idUser` INT NOT NULL,
  `idMappinfFile` INT NOT NULL,
  `element1` VARCHAR(100) NOT NULL,
  `element2` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NULL,
  `validity` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idPairMap`, `idMappinfFile`, `idUser`),
  INDEX `idUser_idx` (`idUser` ASC),
  INDEX `idMappingFile_idx` (`idMappinfFile` ASC),
  CONSTRAINT `idUser`
    FOREIGN KEY (`idUser`)
    REFERENCES `collaborative_mapping`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idMappingFile`
    FOREIGN KEY (`idMappinfFile`)
    REFERENCES `collaborative_mapping`.`mappingFile` (`idMappingFile`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;