CREATE TABLE `documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_master_doc` (`master_id`),
  CONSTRAINT `fk_master_doc` FOREIGN KEY (`master_id`) REFERENCES `documents` (`id`)
);

CREATE TABLE `sections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `document_id` int(11) DEFAULT NULL,
  `order_number` int(11) DEFAULT NULL,
  `couch_db_section_id` varchar(255) DEFAULT NULL,
  `previous_version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_doc` (`document_id`),
  KEY `version` (`previous_version_id`),
  CONSTRAINT `fk_doc` FOREIGN KEY (`document_id`) REFERENCES `documents` (`id`),
  CONSTRAINT `version` FOREIGN KEY (`previous_version_id`) REFERENCES `sections` (`id`)
);

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL UNIQUE,
  `password` varchar(255) DEFAULT NULL,
  `enabled` boolean NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `users_documents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `document_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `permissions` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user` (`user_id`),
  CONSTRAINT `fk_documents` FOREIGN KEY (`document_id`) REFERENCES `documents` (`id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

CREATE TABLE `notifications` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `section_master_id` int(11) DEFAULT NULL,
  `section_slave_id` int(11) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `is_read` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_master` (`section_master_id`),
  KEY `fk_slave` (`section_slave_id`),
  CONSTRAINT `fk_master` FOREIGN KEY (`section_master_id`) REFERENCES `sections` (`id`),
  CONSTRAINT `fk_slave` FOREIGN KEY (`section_slave_id`) REFERENCES `sections` (`id`)
);

create table authorities (
    username varchar(255) not null,
    authority varchar(255) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);