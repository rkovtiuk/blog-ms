CREATE DATABASE IF NOT EXISTS boot_microservices;

ALTER DATABASE boot_microservices
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

GRANT ALL PRIVILEGES ON boot_microservices.* TO root@localhost IDENTIFIED BY 'root';

USE boot_microservices;

CREATE TABLE IF NOT EXISTS users (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  forename VARCHAR(30),
  surname VARCHAR(30),
  organisation VARCHAR(30),
  points INT(4)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS notifications (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  text VARCHAR(80)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS users_notifications (
  user_id INT(4) UNSIGNED NOT NULL,
  notification_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (notification_id) REFERENCES notifications(id),
  UNIQUE (user_id,notification_id)
) engine=InnoDB;