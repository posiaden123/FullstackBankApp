-- Run the first time the server is started

SET FOREIGN_KEY_CHECKS = 0;

create table if not exists `cards`(
`id` integer not null auto_increment,
`card_number` long default null,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table if not exists `accounts` (
	`id` integer not null auto_increment primary key,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	`card_id` integer default null unique ,
    `user` varchar(45) DEFAULT NULL unique ,
	`password` char(68) DEFAULT NULL,
    primary key(`id`),
     KEY `FK_DETAIL_idx` (`card_id`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`card_id`) REFERENCES `cards` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

create table `authorities` (
    `user` varchar(45) not null,
    role varchar(50) not null,
    foreign key (user) references accounts(user)
);

 SET FOREIGN_KEY_CHECKS = 1;
 
