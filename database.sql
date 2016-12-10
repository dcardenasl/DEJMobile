-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DEJMobile
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DEJMobile
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DEJMobile` DEFAULT CHARACTER SET utf8 ;
USE `DEJMobile` ;

-- -----------------------------------------------------
-- Table `DEJMobile`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DEJMobile`.`Cliente` (
  `rut` INT NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidoPaterno` VARCHAR(45) NOT NULL,
  `apellidoMaterno` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `numeracion` INT NOT NULL,
  `comuna` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  PRIMARY KEY (`rut`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DEJMobile`.`Cuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DEJMobile`.`Cuota` (
  `idCuota` INT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`idCuota`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DEJMobile`.`Minutos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DEJMobile`.`Minutos` (
  `idMinutos` INT NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `precio` INT NOT NULL,
  PRIMARY KEY (`idMinutos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DEJMobile`.`Solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DEJMobile`.`Solicitud` (
  `codigo` INT NOT NULL,
  `entrega` TINYINT(1) NULL,
  `total` INT NULL,
  `fechaHora` DATETIME NULL,
  `Cliente_rut` INT NOT NULL,
  `Cuota_idCuota` INT NOT NULL,
  `Minutos_idMinutos` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_Solicitud_Cliente_idx` (`Cliente_rut` ASC),
  INDEX `fk_Solicitud_Cuota1_idx` (`Cuota_idCuota` ASC),
  INDEX `fk_Solicitud_Minutos1_idx` (`Minutos_idMinutos` ASC),
  CONSTRAINT `fk_Solicitud_Cliente`
    FOREIGN KEY (`Cliente_rut`)
    REFERENCES `DEJMobile`.`Cliente` (`rut`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Cuota1`
    FOREIGN KEY (`Cuota_idCuota`)
    REFERENCES `DEJMobile`.`Cuota` (`idCuota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_Minutos1`
    FOREIGN KEY (`Minutos_idMinutos`)
    REFERENCES `DEJMobile`.`Minutos` (`idMinutos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
