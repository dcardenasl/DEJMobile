-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dejmobile
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dejmobile` ;

-- -----------------------------------------------------
-- Schema dejmobile
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dejmobile` DEFAULT CHARACTER SET utf8 ;
USE `dejmobile` ;

-- -----------------------------------------------------
-- Table `dejmobile`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dejmobile`.`cliente` (
  `rut` INT(11) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidoPaterno` VARCHAR(45) NOT NULL,
  `apellidoMaterno` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `numeracion` INT(11) NOT NULL,
  `comuna` VARCHAR(45) NOT NULL,
  `telefono` INT(11) NOT NULL,
  PRIMARY KEY (`rut`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dejmobile`.`cuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dejmobile`.`cuota` (
  `idCuota` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT(11) NOT NULL,
  PRIMARY KEY (`idCuota`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dejmobile`.`minutos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dejmobile`.`minutos` (
  `idMinutos` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT(11) NOT NULL,
  PRIMARY KEY (`idMinutos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dejmobile`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dejmobile`.`solicitud` (
  `codigo` INT(11) NOT NULL,
  `entrega` TINYINT(1) NULL DEFAULT NULL,
  `total` INT(11) NULL DEFAULT NULL,
  `fechaHora` DATETIME NULL DEFAULT NULL,
  `Cliente_rut` INT(11) NOT NULL,
  `Cuota_idCuota` INT(11) NOT NULL,
  `Minutos_idMinutos` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Solicitud_Cliente_idx` (`Cliente_rut` ASC),
  INDEX `fk_Solicitud_Cuota1_idx` (`Cuota_idCuota` ASC),
  INDEX `fk_Solicitud_Minutos1_idx` (`Minutos_idMinutos` ASC),
  CONSTRAINT `fk_Solicitud_Cliente`
    FOREIGN KEY (`Cliente_rut`)
    REFERENCES `dejmobile`.`cliente` (`rut`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Cuota1`
    FOREIGN KEY (`Cuota_idCuota`)
    REFERENCES `dejmobile`.`cuota` (`idCuota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Minutos1`
    FOREIGN KEY (`Minutos_idMinutos`)
    REFERENCES `dejmobile`.`minutos` (`idMinutos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
