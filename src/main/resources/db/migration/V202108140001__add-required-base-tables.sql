CREATE TABLE IF NOT EXISTS `Tweet` (
	`tweetId` VARCHAR(100) NOT NULL,
	`text` VARCHAR(1000) NULL,
	`createDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`updateDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`deleteDate` TIMESTAMP NULL,
PRIMARY KEY (`tweetId`));

CREATE TABLE IF NOT EXISTS `HashTag` (
	`tagId` INT(20) NOT NULL,
	`tagName` VARCHAR(100) NULL,
	`createDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`updateDate` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`deleteDate` TIMESTAMP NULL,
PRIMARY KEY (`tagId`));

CREATE TABLE IF NOT EXISTS `TweetHashTagMap` (
	`tweetId` VARCHAR(100) NOT NULL,
	`tagId` INT(20) NOT NULL,
PRIMARY KEY (`tweetId`, `tagId`));
