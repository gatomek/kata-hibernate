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
    `dateTime` DATETIME,
    `lastName` VARCHAR(50),
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `training_id` BIGINT,
    `author` VARCHAR(50) NOT NULL,
    `comment` VARCHAR(400) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_review_training`
    FOREIGN KEY ( `training_id`)
    REFERENCES `training` (`id`)
    ON DELETE CASCADE
    ON UPDATE  CASCADE
);
