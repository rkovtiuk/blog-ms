INSERT IGNORE INTO users VALUES (1, 'robertkovtiuk@gmail.com', 'Robert', 'DevCtrl', 'qwe123', 1, 'Kovtiuk');

INSERT IGNORE INTO notifications VALUES (1, 'Hello', 'Welcome to BlogMS', 1),
                                        (2, 'Hello again', 'Introduce', 1);

INSERT IGNORE INTO blog_categories VALUES (1, 'Java'),
                                          (2, 'Spring');

INSERT IGNORE INTO blogs VALUE (1, 1502710910324, 'Java is OOP language', 'Java history', 1, 1);

INSERT IGNORE INTO comments VALUES (1, 1502711116857, 'First one', NULL, 1, 1),
                                   (2, 1502711117000, 'Answer', 1, 1, 1),
                                   (3, 1502711118000, 'New comment', NULL, 1, 1);