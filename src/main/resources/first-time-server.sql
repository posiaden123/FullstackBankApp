-- Run the first time the server is started

SET FOREIGN_KEY_CHECKS = 0;

create table if not exists `cards`(
`id` integer not null auto_increment,
`card_number` long default null,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table if not exists `accounts` (
	`id` integer not null auto_increment,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	`card_id` integer default null,
    `user` varchar(45) DEFAULT NULL,
	`password` char(60) DEFAULT NULL,
    primary key(`id`),
     KEY `FK_DETAIL_idx` (`card_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
    
 SET FOREIGN_KEY_CHECKS = 1;
 
