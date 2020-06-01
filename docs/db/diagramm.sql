CREATE TABLE `location` (
  `id` int PRIMARY KEY NOT NULL,
  `city` varchar(63) NOT NULL,
  `street` varchar(63) NOT NULL,
  `zip` varchar(15),
  `address` varchar(255) NOT NULL
);

CREATE TABLE `user` (
  `id` int PRIMARY KEY NOT NULL,
  `firstname` varchar(63) NOT NULL,
  `middlename` varchar(63),
  `lastname` varchar(63) NOT NULL,
  `sex` char NOT NULL COMMENT 'm (male), f (female)',
  `birthdate` date,
  `email` varchar(255) NOT NULL,
  `location` int,
  `position` varchar(255),
  `password` char(40) COMMENT 'SHA1(password+salt), password=NULL and position=NULL for patient',
  `status` char NOT NULL COMMENT 'a (active), d (disabled)',
  `photo` blob,
  `description` varchar(1022)
);

CREATE TABLE `medicine` (
  `id` int PRIMARY KEY NOT NULL
);

CREATE TABLE `diagnosis` (
  `id` int PRIMARY KEY NOT NULL
);

CREATE TABLE `clinical_record` (
  `id` int PRIMARY KEY NOT NULL,
  `doctor` int NOT NULL COMMENT 'password != NULL and status=a',
  `patient` int NOT NULL,
  `location` int,
  `conclusion` varchar(1022) NOT NULL,
  `created` datetime DEFAULT "now()"
);

CREATE TABLE `clinical_record__medicine` (
  `clinical_record` int NOT NULL,
  `medicine` int NOT NULL,
  `reception` varchar(255),
  PRIMARY KEY (`clinical_record`, `medicine`)
);

CREATE TABLE `clinical_record__diagnosis` (
  `clinical_record` int NOT NULL,
  `diagnosis` int NOT NULL,
  `reception` varchar(255),
  PRIMARY KEY (`clinical_record`, `diagnosis`)
);

ALTER TABLE `user` ADD FOREIGN KEY (`location`) REFERENCES `location` (`id`);

ALTER TABLE `clinical_record` ADD FOREIGN KEY (`doctor`) REFERENCES `user` (`id`);

ALTER TABLE `clinical_record` ADD FOREIGN KEY (`patient`) REFERENCES `user` (`id`);

ALTER TABLE `clinical_record` ADD FOREIGN KEY (`location`) REFERENCES `location` (`id`);

ALTER TABLE `clinical_record__medicine` ADD FOREIGN KEY (`clinical_record`) REFERENCES `clinical_record` (`id`);

ALTER TABLE `clinical_record__medicine` ADD FOREIGN KEY (`medicine`) REFERENCES `medicine` (`id`);

ALTER TABLE `clinical_record__diagnosis` ADD FOREIGN KEY (`clinical_record`) REFERENCES `clinical_record` (`id`);

ALTER TABLE `clinical_record__diagnosis` ADD FOREIGN KEY (`diagnosis`) REFERENCES `diagnosis` (`id`);

CREATE UNIQUE INDEX `location_index_0` ON `location` (`city`, `street`, `zip`, `address`);

CREATE UNIQUE INDEX `user_index_1` ON `user` (`firstname`, `middlename`, `lastname`, `birthdate`);
