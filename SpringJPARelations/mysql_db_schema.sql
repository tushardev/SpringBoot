create table studyjpa.author
(id int(10),
first_name varchar(50),
last_name varchar(50),
date_of_birth datetime);

alter table studyjpa.author change id id int (10) AUTO_INCREMENT;

CREATE TABLE `music_institute` (
  `institute_id` int(10) NOT NULL AUTO_INCREMENT,
  `institute_name` varchar(50) DEFAULT NULL,
  `institute_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`institute_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

CREATE TABLE `cd` (
  `cd_id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `unit_cost` float DEFAULT NULL,
  `duration` int(3) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;


CREATE TABLE `musician` (
  `musician_id` int(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `primary_instrument` varchar(20) DEFAULT NULL,
  `institute_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`musician_id`),
  KEY `institute_id` (`institute_id`),
  CONSTRAINT `musician_ibfk_1` FOREIGN KEY (`institute_id`) REFERENCES `music_institute` (`institute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

CREATE TABLE `musician_cds` (
  `mapping_id` int(10) NOT NULL AUTO_INCREMENT,
  `cd_id` int(10) NOT NULL,
  `musician_id` int(10) NOT NULL,
  PRIMARY KEY (`mapping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

