CREATE TABLE ZonesFile (
  `id` INTEGER primary key AUTOINCREMENT,
  `type` INTEGER,
  `name` string,
  `text` string,
  `user` string
);

CREATE TABLE User_Passport (
  `id` INTEGER primary key AUTOINCREMENT,
  `username` text UNIQUE,
  `passwordSalt` string,
  `salt` string,
  `ticket` text UNIQUE
);