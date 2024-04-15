CREATE TABLE `STUDENT` (
	`ID` SERIAL,
	`NO` VARCHAR(10) NOT NULL,
	`NAME` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
	`ENT_YEAR` INT(10) DEFAULT NULL,
	`CLASS_NUM` CHAR(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
	`IS_ATTEND` BOOLEAN DEFAULT NULL,
	`SCHOOL_CD` CHAR CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
	PRIMARY KEY (`NO`)
) ENGINE=InnoDB;