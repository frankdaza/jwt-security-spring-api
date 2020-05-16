INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (3, 'ROLE_REPORTS');

INSERT INTO account (id, username, password, enabled, name) VALUES (1, 'MYADMIN', '123456', true, 'MY ADMIN');
INSERT INTO account (id, username, password, enabled, name) VALUES (2, 'MYUSER', '123456', true, 'MY USER');

INSERT INTO account_role (id, account_id, role_id) VALUES (1, 1, 1);
INSERT INTO account_role (id, account_id, role_id) VALUES (2, 1, 2);
INSERT INTO account_role (id, account_id, role_id) VALUES (3, 1, 3);
INSERT INTO account_role (id, account_id, role_id) VALUES (4, 2, 2);
INSERT INTO account_role (id, account_id, role_id) VALUES (5, 2, 3);
