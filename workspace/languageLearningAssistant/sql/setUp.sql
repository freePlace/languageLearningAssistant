-- Insertion of metadata
INSERT INTO metadata (metadata_id, author_name, project_name) VALUES (1, 'freePlace', 'languageLearningAssistant');

-- Insert into main menu item
INSERT INTO main_menu_item VALUES (1, '', 'Main', '');
INSERT INTO main_menu_item VALUES (2, '', 'Statistics', '');
INSERT INTO main_menu_item VALUES (3, '', 'Trainings', '');
INSERT INTO main_menu_item VALUES (4, '', 'Courses', '');

-- Insertion of site content
INSERT INTO site_content
VALUES (1, 'Welcome! Please login below', '', '����� ����������! ����������, ���������������:');
INSERT INTO site_content VALUES (2, 'Login', '', '�����������');
INSERT INTO site_content VALUES (3, 'Create new user', '', '������� ������ ������������');

INSERT INTO site_content VALUES (4, 'Name', '', '���');
INSERT INTO site_content VALUES (5, 'Last name', '', '�������');
INSERT INTO site_content VALUES (6, 'Native language', '', '������ ����');
INSERT INTO site_content VALUES (7, 'email', '', '���');
INSERT INTO site_content VALUES (8, 'login', '', '�����');
INSERT INTO site_content VALUES (9, 'password', '', '������');
INSERT INTO site_content VALUES (10, 'repeat password', '', '��������� ������');
INSERT INTO site_content VALUES (11, 'Create', '', '�������');

INSERT INTO site_content VALUES (12, 'Add new comment', '', '�������� ����� �����������');
INSERT INTO site_content VALUES (13, 'Submit comment', '', '��������� �����������');
INSERT INTO site_content VALUES (14, 'Comments', '', '�����������');
INSERT INTO site_content VALUES (15, 'Search', '', '�����');
INSERT INTO site_content VALUES (16, 'Main', '', '�������');
INSERT INTO site_content VALUES (17, 'Statistics', '', '����������');
INSERT INTO site_content VALUES (18, 'Trainings', '', '����������');
INSERT INTO site_content VALUES (19, 'Courses', '', '�����');
INSERT INTO site_content VALUES (20, 'Author', '', '�����');
INSERT INTO site_content VALUES (21, 'Date/time', '', '����/�����');
INSERT INTO site_content VALUES (22, 'Task', '', '�������');
INSERT INTO site_content VALUES (23, 'Complete', '', '��������');
INSERT INTO site_content VALUES (24, 'User profile', '', '������� ������������');
INSERT INTO site_content VALUES (25, 'Settings', '', '���������');
INSERT INTO site_content VALUES (26, 'Logout', '', '�����');

-- Insertion of languages
INSERT INTO language (language_id, language_name) VALUES (1, 'English');
INSERT INTO language (language_id, language_name) VALUES (2, 'Russian');
INSERT INTO language (language_id, language_name) VALUES (3, 'French');
-- Insertion of roles
INSERT INTO role (role_id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (role_id, name) VALUES (2, 'ROLE_USER');
-- Insertion of user accounts
INSERT INTO user_account (user_account_id, is_enabled, is_expired, is_expired_credentials, is_locked)
VALUES (1, 1, 0, 0, 0);
INSERT INTO user_account (user_account_id, is_enabled, is_expired, is_expired_credentials, is_locked)
VALUES (2, 1, 0, 0, 0);
-- Insertion of users
INSERT INTO user (user_id, email, last_name, login, name, password, role_id, user_account_id, language_id)
VALUES (1, 'admin@gmail.com', 'admin', 'admin', 'admin', 'admin', 1, 1, 1);
INSERT INTO user (user_id, email, last_name, login, name, password, role_id, user_account_id, language_id)
VALUES (2, 'user@gmail.com', 'user', 'user', 'user', 'user', 2, 2, 2);

-- Insertion of messages
INSERT INTO user_message (user_message_id, date, is_critical, is_new, text, user_id_sent, user_id_recieved)
VALUES (1, now(), 1, 1, 'Hey, bro! how are you?', 1, 2);
INSERT INTO user_message (user_message_id, date, is_critical, is_new, text, user_id_sent, user_id_recieved)
VALUES (2, now(), 1, 1, 'Fine, thnx)', 2, 1);

-- Insertion of comments
INSERT INTO comment (comment_id, date, message, user_id) VALUES (1, now(), 'Comment text.', 1);