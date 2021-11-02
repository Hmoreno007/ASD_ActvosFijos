-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema apiactivosfijos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema apiactivosfijos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apiactivosfijos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `apiactivosfijos` ;

-- -----------------------------------------------------
-- Table `apiactivosfijos`.`ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiactivosfijos`.`ciudades` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ciudad_codigo` VARCHAR(30) NULL DEFAULT NULL,
  `ciudad_nombre` VARCHAR(50) NULL DEFAULT NULL,
  `latitud` VARCHAR(50) NOT NULL,
  `longitud` VARCHAR(50) NOT NULL,
  `estado` VARCHAR(2) NULL DEFAULT NULL,
  `fecha_hora_crea` TIMESTAMP NULL DEFAULT NULL,
  `fecha_hora_modifica` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `apiactivosfijos`.`areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiactivosfijos`.`areas` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `area_codigo` VARCHAR(30) NULL DEFAULT NULL,
  `area_nombre` VARCHAR(50) NULL DEFAULT NULL,
  `estado` VARCHAR(2) NULL DEFAULT NULL,
  `ciudad_id` BIGINT UNSIGNED NOT NULL,
  `fecha_hora_crea` TIMESTAMP NULL DEFAULT NULL,
  `fecha_hora_modifica` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `areas_ibfk_1`
    FOREIGN KEY (`ciudad_id`)
    REFERENCES `apiactivosfijos`.`ciudades` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `ciudad_id` ON `apiactivosfijos`.`areas` (`ciudad_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `apiactivosfijos`.`activosfijos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiactivosfijos`.`activosfijos` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `activo_nombre` VARCHAR(255) NULL DEFAULT NULL,
  `activo_serial` VARCHAR(255) NULL DEFAULT NULL,
  `alto` DOUBLE NOT NULL,
  `ancho` DOUBLE NOT NULL,
  `descripcion` VARCHAR(255) NULL DEFAULT NULL,
  `estado` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_hora_compra` DATETIME(6) NULL DEFAULT NULL,
  `fecha_hora_crea` DATETIME(6) NULL DEFAULT NULL,
  `fecha_hora_modifica` DATETIME(6) NULL DEFAULT NULL,
  `largo` DOUBLE NOT NULL,
  `num_int_inventario` VARCHAR(255) NULL DEFAULT NULL,
  `peso` DOUBLE NOT NULL,
  `tipo` VARCHAR(255) NULL DEFAULT NULL,
  `valor_compra` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `apiactivosfijos`.`activoarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiactivosfijos`.`activoarea` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  `area_id` BIGINT UNSIGNED NOT NULL,
  `activo_id` BIGINT UNSIGNED NOT NULL,
  `estado` VARCHAR(2) NULL DEFAULT NULL,
  `fecha_hora_crea` TIMESTAMP NULL DEFAULT NULL,
  `fecha_hora_modifica` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `activoarea_ibfk_1`
    FOREIGN KEY (`area_id`)
    REFERENCES `apiactivosfijos`.`areas` (`id`),
  CONSTRAINT `activoarea_ibfk_2`
    FOREIGN KEY (`activo_id`)
    REFERENCES `apiactivosfijos`.`activosfijos` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `area_id` ON `apiactivosfijos`.`activoarea` (`area_id` ASC) VISIBLE;

CREATE INDEX `activo_id` ON `apiactivosfijos`.`activoarea` (`activo_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `apiactivosfijos`.`personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiactivosfijos`.`personas` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `tipo_documento` VARCHAR(30) NULL DEFAULT NULL,
  `numero_documento` VARCHAR(50) NULL DEFAULT NULL,
  `nombre_completo` VARCHAR(100) NULL DEFAULT NULL,
  `estado` VARCHAR(2) NULL DEFAULT NULL,
  `fecha_hora_crea` TIMESTAMP NULL DEFAULT NULL,
  `fecha_hora_modifica` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `apiactivosfijos`.`activopersona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apiactivosfijos`.`activopersona` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  `persona_id` BIGINT UNSIGNED NOT NULL,
  `activo_id` BIGINT UNSIGNED NOT NULL,
  `estado` VARCHAR(2) NULL DEFAULT NULL,
  `fecha_hora_crea` TIMESTAMP NULL DEFAULT NULL,
  `fecha_hora_modifica` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `activopersona_ibfk_1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `apiactivosfijos`.`personas` (`id`),
  CONSTRAINT `activopersona_ibfk_2`
    FOREIGN KEY (`activo_id`)
    REFERENCES `apiactivosfijos`.`activosfijos` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `persona_id` ON `apiactivosfijos`.`activopersona` (`persona_id` ASC) VISIBLE;

CREATE INDEX `activo_id` ON `apiactivosfijos`.`activopersona` (`activo_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
