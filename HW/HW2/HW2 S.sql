-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema HW2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema HW2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `HW2` DEFAULT CHARACTER SET utf8 ;
USE `HW2` ;

-- -----------------------------------------------------
-- Table `HW2`.`AIRPORT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`AIRPORT` (
  `Airport_code` INT NOT NULL,
  `City` VARCHAR(45) NULL,
  `State` VARCHAR(45) NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Airport_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`AIRPLANE_TYPE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`AIRPLANE_TYPE` (
  `Type_name` INT NOT NULL,
  `Max_seats` INT NOT NULL,
  `Companyl` VARCHAR(45) NULL,
  PRIMARY KEY (`Type_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`AIRPLANE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`AIRPLANE` (
  `Airplane_id` INT NOT NULL,
  `Total_no_of_seats` VARCHAR(45) NULL,
  `AIRPLANE_TYPE_Type_name` INT NOT NULL,
  PRIMARY KEY (`Airplane_id`),
  INDEX `fk_AIRPLANE_AIRPLANE_TYPE1_idx` (`AIRPLANE_TYPE_Type_name` ASC),
  CONSTRAINT `fk_AIRPLANE_AIRPLANE_TYPE1`
    FOREIGN KEY (`AIRPLANE_TYPE_Type_name`)
    REFERENCES `HW2`.`AIRPLANE_TYPE` (`Type_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`FLIGHT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`FLIGHT` (
  `Number` INT NULL,
  `Airline` VARCHAR(45) NULL,
  `Weekdays` VARCHAR(45) NULL,
  PRIMARY KEY (`Number`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`FLIGHT_LEG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`FLIGHT_LEG` (
  `Leg_no` INT NOT NULL,
  `FLIGHT_Number` INT NOT NULL,
  `AIRPORT_Airport_code` INT NOT NULL,
  `AIRPORT_Airport_code1` INT NOT NULL,
  `Scheduled_dep_time` VARCHAR(45) NULL,
  `Scheduled_arr_time` VARCHAR(45) NULL,
  PRIMARY KEY (`Leg_no`, `FLIGHT_Number`),
  INDEX `fk_FLIGHT_LEG_FLIGHT_idx` (`FLIGHT_Number` ASC),
  INDEX `fk_FLIGHT_LEG_AIRPORT1_idx` (`AIRPORT_Airport_code` ASC),
  INDEX `fk_FLIGHT_LEG_AIRPORT2_idx` (`AIRPORT_Airport_code1` ASC),
  CONSTRAINT `fk_FLIGHT_LEG_FLIGHT`
    FOREIGN KEY (`FLIGHT_Number`)
    REFERENCES `HW2`.`FLIGHT` (`Number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FLIGHT_LEG_AIRPORT1`
    FOREIGN KEY (`AIRPORT_Airport_code`)
    REFERENCES `HW2`.`AIRPORT` (`Airport_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FLIGHT_LEG_AIRPORT2`
    FOREIGN KEY (`AIRPORT_Airport_code1`)
    REFERENCES `HW2`.`AIRPORT` (`Airport_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`FARE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`FARE` (
  `Code` INT NOT NULL,
  `Amount` VARCHAR(45) NULL,
  `Restriction` VARCHAR(45) NULL,
  `FLIGHT_Number` INT NOT NULL,
  PRIMARY KEY (`Code`, `FLIGHT_Number`),
  INDEX `fk_FARE_FLIGHT1_idx` (`FLIGHT_Number` ASC),
  CONSTRAINT `fk_FARE_FLIGHT1`
    FOREIGN KEY (`FLIGHT_Number`)
    REFERENCES `HW2`.`FLIGHT` (`Number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`LEG_INSTANCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`LEG_INSTANCE` (
  `FLIGHT_LEG_Leg_no` INT NOT NULL,
  `FLIGHT_LEG_FLIGHT_Number` INT NOT NULL,
  `Date` VARCHAR(45) NULL,
  `AIRPLANE_Airplane_id` INT NOT NULL,
  `No_of_avail_seats` VARCHAR(45) NULL,
  `AIRPORT_Airport_code` INT NOT NULL,
  `AIRPORT_Airport_code1` INT NOT NULL,
  `Arr_time` VARCHAR(45) NULL,
  `Dep_time` VARCHAR(45) NULL,
  PRIMARY KEY (`FLIGHT_LEG_Leg_no`, `FLIGHT_LEG_FLIGHT_Number`, `Date`),
  INDEX `fk_LEG_INSTANCE_AIRPORT1_idx` (`AIRPORT_Airport_code` ASC),
  INDEX `fk_LEG_INSTANCE_AIRPORT2_idx` (`AIRPORT_Airport_code1` ASC),
  INDEX `fk_LEG_INSTANCE_AIRPLANE1_idx` (`AIRPLANE_Airplane_id` ASC),
  CONSTRAINT `fk_LEG_INSTANCE_FLIGHT_LEG1`
    FOREIGN KEY (`FLIGHT_LEG_Leg_no` , `FLIGHT_LEG_FLIGHT_Number`)
    REFERENCES `HW2`.`FLIGHT_LEG` (`Leg_no` , `FLIGHT_Number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LEG_INSTANCE_AIRPORT1`
    FOREIGN KEY (`AIRPORT_Airport_code`)
    REFERENCES `HW2`.`AIRPORT` (`Airport_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LEG_INSTANCE_AIRPORT2`
    FOREIGN KEY (`AIRPORT_Airport_code1`)
    REFERENCES `HW2`.`AIRPORT` (`Airport_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LEG_INSTANCE_AIRPLANE1`
    FOREIGN KEY (`AIRPLANE_Airplane_id`)
    REFERENCES `HW2`.`AIRPLANE` (`Airplane_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`SEAT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`SEAT` (
  `Seat_no` INT NOT NULL,
  `LEG_INSTANCE_FLIGHT_LEG_Leg_no` INT NOT NULL,
  `LEG_INSTANCE_FLIGHT_LEG_FLIGHT_Number` INT NOT NULL,
  `LEG_INSTANCE_Date` VARCHAR(45) NOT NULL,
  `Cphone` VARCHAR(45) NULL,
  `Customer_name` VARCHAR(45) NULL,
  PRIMARY KEY (`Seat_no`, `LEG_INSTANCE_FLIGHT_LEG_Leg_no`, `LEG_INSTANCE_FLIGHT_LEG_FLIGHT_Number`, `LEG_INSTANCE_Date`),
  INDEX `fk_SEAT_LEG_INSTANCE1_idx` (`LEG_INSTANCE_FLIGHT_LEG_Leg_no` ASC, `LEG_INSTANCE_FLIGHT_LEG_FLIGHT_Number` ASC, `LEG_INSTANCE_Date` ASC),
  CONSTRAINT `fk_SEAT_LEG_INSTANCE1`
    FOREIGN KEY (`LEG_INSTANCE_FLIGHT_LEG_Leg_no` , `LEG_INSTANCE_FLIGHT_LEG_FLIGHT_Number` , `LEG_INSTANCE_Date`)
    REFERENCES `HW2`.`LEG_INSTANCE` (`FLIGHT_LEG_Leg_no` , `FLIGHT_LEG_FLIGHT_Number` , `Date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HW2`.`CAN_LAND`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HW2`.`CAN_LAND` (
  `AIRPORT_Airport_code` INT NOT NULL,
  `AIRPLANE_TYPE_Type_name` INT NOT NULL,
  INDEX `fk_CAN_LAND_AIRPLANE_TYPE1_idx` (`AIRPLANE_TYPE_Type_name` ASC),
  PRIMARY KEY (`AIRPORT_Airport_code`, `AIRPLANE_TYPE_Type_name`),
  CONSTRAINT `fk_CAN_LAND_AIRPLANE_TYPE1`
    FOREIGN KEY (`AIRPLANE_TYPE_Type_name`)
    REFERENCES `HW2`.`AIRPLANE_TYPE` (`Type_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CAN_LAND_AIRPORT1`
    FOREIGN KEY (`AIRPORT_Airport_code`)
    REFERENCES `HW2`.`AIRPORT` (`Airport_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
