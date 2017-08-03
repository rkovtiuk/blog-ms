DROP TABLE users IF EXISTS;
DROP TABLE notifications IF EXISTS;
DROP TABLE users_notifications IF EXISTS;

CREATE TABLE users (
  id            INTEGER IDENTITY PRIMARY KEY,
  forename      VARCHAR(30),
  surname       VARCHAR(30),
  organisation  VARCHAR(30),
  points        INTEGER
);

CREATE TABLE notifications (
  id            INTEGER IDENTITY PRIMARY KEY,
  text          VARCHAR(50)
);

CREATE TABLE users_notifications(
  user_id         INTEGER NOT NULL,
  notification_id INTEGER NOT NULL
);

ALTER TABLE users_notifications ADD CONSTRAINT fk_users_notification_users FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_notifications ADD CONSTRAINT fk_users_notification_notification FOREIGN KEY (notification_id) REFERENCES notifications (id);