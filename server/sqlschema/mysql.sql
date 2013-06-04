CREATE TABLE ZonesFile (
  `id`   INTEGER PRIMARY KEY AUTO_INCREMENT,
  `type` INTEGER,
  `name` VARCHAR(100),
  `text` VARCHAR(10000),
  `user` VARCHAR(100)
)
  ENGINE ="innodb"
  DEFAULT CHARSET utf8;

CREATE TABLE User_Passport (
  `id`           INTEGER PRIMARY KEY AUTO_INCREMENT,
  `username`     VARCHAR(100) UNIQUE,
  `passwordSalt` VARCHAR(100),
  `salt`         VARCHAR(100),
  `ticket`       VARCHAR(100) UNIQUE,
  `zones`        VARCHAR(10000) DEFAULT "",
  UNIQUE KEY `uk_username` (`username`),
  UNIQUE KEY `uk_ticket` (`ticket`)
)
  ENGINE ="innodb"
  DEFAULT CHARSET utf8;