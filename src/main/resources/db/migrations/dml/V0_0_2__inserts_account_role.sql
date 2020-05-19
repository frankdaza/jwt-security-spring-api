INSERT INTO role (id, name, created_at, created_by) VALUES (1, 'ROLE_ADMIN', '2020-05-18', 'MYADMIN');
INSERT INTO role (id, name, created_at, created_by) VALUES (2, 'ROLE_USER', '2020-05-18', 'MYADMIN');
INSERT INTO role (id, name, created_at, created_by) VALUES (3, 'ROLE_REPORTS', '2020-05-18', 'MYADMIN');

INSERT INTO account (id, username, password, enabled, name, created_at, created_by)
    VALUES (1, 'MYADMIN', '$2a$10$0aPv3UNN20qm/Z.uaf8h.uqUcr4LZ.OCjlGXrcw93eu1WctgwaZl6', true, 'MY ADMIN', '2020-05-18', 'MYADMIN');
INSERT INTO account (id, username, password, enabled, name, created_at, created_by)
    VALUES (2, 'MYUSER', '$2a$10$aDVsEFyDWAmr3X8QZsBOeu81hVvrK7HCGtox1TENz0/s1LTMaxkTW', true, 'MY USER', '2020-05-18', 'MYADMIN');
INSERT INTO account (id, username, password, enabled, name, created_at, created_by)
    VALUES (3, 'MYREPORTS', '$2a$10$wjFrgay.XmPeYG9qYrjtTOIOlSySWVEz80BE38.QnenCooTzIVBpa', true, 'MY USER', '2020-05-18', 'MYADMIN');


INSERT INTO account_role (id, account_id, role_id, created_at, created_by) VALUES (1, 1, 1, '2020-05-18', 'MYADMIN');
INSERT INTO account_role (id, account_id, role_id, created_at, created_by) VALUES (2, 1, 2, '2020-05-18', 'MYADMIN');
INSERT INTO account_role (id, account_id, role_id, created_at, created_by) VALUES (3, 1, 3, '2020-05-18', 'MYADMIN');
INSERT INTO account_role (id, account_id, role_id, created_at, created_by) VALUES (4, 2, 2, '2020-05-18', 'MYADMIN');
INSERT INTO account_role (id, account_id, role_id, created_at, created_by) VALUES (5, 3, 3, '2020-05-18', 'MYADMIN');
