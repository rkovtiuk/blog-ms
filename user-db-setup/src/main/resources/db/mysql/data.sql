INSERT IGNORE INTO users VALUES (1, 'James', 'Carter', 'DevCtrl', 20);

INSERT IGNORE INTO notifications VALUES (1, 'Hello');
INSERT IGNORE INTO notifications VALUES (2, 'Hello again');

INSERT IGNORE INTO users_notifications VALUES (1, 1);
INSERT IGNORE INTO users_notifications VALUES (1, 2);
