-- MySQL Script generated by MySQL Workbench
-- Sun Apr  6 08:22:20 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema agrop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agrop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agrop` DEFAULT CHARACTER SET utf8mb3 ;
USE `agrop` ;

-- -----------------------------------------------------
-- Table `agrop`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrop`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(16) NOT NULL,
  `contraseña` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `nombre_usuario_UNIQUE` (`nombre_usuario` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `agrop`.`carpeta_lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrop`.`carpeta_lote` (
  `id_lote` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `nombre_lote` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id_lote`),
  INDEX `CONSTRAINT` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `creado_por`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `agrop`.`usuario` (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `agrop`.`detalle_suelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agrop`.`detalle_suelo` (
  `id_detalle_suelo` INT NOT NULL AUTO_INCREMENT,
  `id_lote` INT NOT NULL,
  `pH` FLOAT NOT NULL,
  `temperatura_suelo` FLOAT NOT NULL,
  `temperatura_ambiente` FLOAT NOT NULL,
  `humedad_suelo` FLOAT NOT NULL,
  `humedad_ambiente` FLOAT NOT NULL,
  `nitrogeno` FLOAT NOT NULL,
  `fosforo` FLOAT NULL DEFAULT NULL,
  `tiempo` DATETIME NOT NULL,
  PRIMARY KEY (`id_detalle_suelo`),
  INDEX `nombre_suelo_idx` (`id_lote` ASC) VISIBLE,
  CONSTRAINT `nombre_suelo`
    FOREIGN KEY (`id_lote`)
    REFERENCES `agrop`.`carpeta_lote` (`id_lote`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
