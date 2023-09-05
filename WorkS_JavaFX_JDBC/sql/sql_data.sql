/* CREATE A DATABASE */
CREATE DATABASE IF NOT EXISTS student_db;

USE student_db;

/* Create a table called employees */

DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS `employees` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `last_name` VARCHAR(64) DEFAULT NULL,
    `first_name` VARCHAR(64) DEFAULT NULL,
    `email` VARCHAR(64) DEFAULT NULL,
    `department` VARCHAR(64) DEFAULT NULL,
    `salary` DECIMAL(10,2) DEFAULT NULL,
    
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Add emplyee records to the table */
INSERT INTO `employees` (`id`,`last_name`, `first_name`, `email`, `department`, `salary`) 
VALUES (1, 'Jones', 'Carey', 'carey.jones@psu.edu', 'HR', 55000.00);

INSERT INTO `employees` (`id`,`last_name`, `first_name`, `email`, `department`, `salary`) 
VALUES (2, 'Hamm', 'Denise', 'denise.hamm@psu.edu', 'Engeneering', 75000.00);

INSERT INTO `employees` (`id`,`last_name`, `first_name`, `email`, `department`, `salary`) 
VALUES (3, 'Jensen', 'Jacob', 'jacob.jensen@psu.edu', 'Legal', 130000.00);

INSERT INTO `employees` (`last_name`, `first_name`, `email`, `department`, `salary`) 
VALUES ('Erbele', 'Paula', 'paula.erbele@psu.edu', 'HR', 120000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (5,'Short','Marcus','marcus.short@psu.edu', 'Engineering', 50000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (6,'Wong','Joanna','joanna.wong@psu.edu', 'Legal', 100000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (7,'Cotton','Kevin','kevin.cotton@psu.edu', 'HR', 50000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (8,'Tracy','Debra','debra.tracy@psu.edu', 'Engineering', 50000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (9,'Applewhite','George','george.applewhite@psu.edu', 'Legal', 80000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (10,'Hammond','Noreen','noreen.hammond@psu.edu', 'HR', 45000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (11,'Castaneda','Jay','jay.castaneda@psu.edu', 'Engineering', 65000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (12,'Hahn','Peggy','peggy.hahn@psu.edu', 'Legal', 90000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (13,'Danielson','Carl','carl.danielson@psu.edu', 'Engineering', 65000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (14,'Yulesetti','Freddy','freddy.yulesetti@psu.edu', 'Legal', 100000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (15,'Cotton','Kevin','kevin.cotton@psu.edu', 'HR', 72000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (16,'White','Walter','walter.white@psu.edu', 'Engineering', 150000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (17,'Fring','Gustavo','gustavo.fring@psu.edu', 'Legal', 95000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (18,'Ehrmentraut','Mike','mike.ehrmentraut@psu.edu', 'HR', 53000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (19,'Woosley','Carl','carl.woosley@psu.edu', 'Engineering', 57000.00);

INSERT INTO `employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) 
VALUES (20,'Helvey','Mark','mark.helvey@psu.edu', 'Legal', 88000.00);
