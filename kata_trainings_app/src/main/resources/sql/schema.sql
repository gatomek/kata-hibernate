DROP TABLE IF EXISTS `training`;
CREATE TABLE `training` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `dateTime` DATETIME,
    `description` VARCHAR(100),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50),
    `created` DATETIME,
    `lastName` VARCHAR(50),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `training_id` BIGINT NOT NULL,
    `author` VARCHAR(50) NOT NULL,
    `comment` VARCHAR(400) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_review_training`
    FOREIGN KEY ( `training_id`)
    REFERENCES `training` (`id`)
    ON DELETE CASCADE
    ON UPDATE  CASCADE
);

DROP TABLE IF EXISTS `note`;
CREATE TABLE `note` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `training_id` BIGINT NOT NULL ,
  `text` VARCHAR(400) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_note_training`
      FOREIGN KEY ( `training_id`)
      REFERENCES `training` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `details`;
CREATE TABLE `details` (
   `id` BIGINT NOT NULL AUTO_INCREMENT,
   `points` BIGINT NULL,
   PRIMARY KEY (`id`)
);

Alter table `training` add column `details_id` BIGINT Null;

drop table if exists `training_user`;
create table `training_user` (
    `training_id` BIGINT NOT NULL,
    `user_id` BIGINT NOT NULL,
    primary key (`training_id`, `user_id`),
    constraint `fk_training_user_training` foreign key (`training_id`) references `training` (`id`),
    constraint `fk_training_user_user` foreign key (`user_id`) references `user` (`id`)
)
