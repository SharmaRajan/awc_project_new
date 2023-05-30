
CREATE DATABASE eazybank;

use eazybank;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT IGNORE INTO users VALUES ('happy','12345','1');
INSERT IGNORE INTO authorities VALUES ('happy','write');


create table customer (
	id int not null auto_increment,
    email varchar(45) not null,
	pwd varchar(200) not null,
	role varchar(45) not null,
    primary key(id)
);


insert into customer(email, pwd,role) values('johndoe@gmail.com','54321','admin');







