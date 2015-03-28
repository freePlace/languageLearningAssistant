-- Insertion of metadata
INSERT INTO metadata(metadata_id, author_name, project_name) VALUES(1,'freePlace','languageLearningAssistant');

-- Insert into main menu item
INSERT INTO main_menu_item VALUES(1, '', 'Main','');
INSERT INTO main_menu_item VALUES(2, '', 'Statistics','');
INSERT INTO main_menu_item VALUES(3, '', 'Trainings','');
INSERT INTO main_menu_item VALUES(4, '', 'Courses','');

-- Insertion of site content
INSERT INTO site_content VALUES(1,'Welcome! Please login below','','Добро пожаловать! Пожалуйста, авторизируйтесь:');
INSERT INTO site_content VALUES(2,'Login','','Авторизация');
INSERT INTO site_content VALUES(3,'Create new user','','Создать нового пользователя');

INSERT INTO site_content VALUES(4,'Name','','Имя');
INSERT INTO site_content VALUES(5,'Last name','','Фамилия');
INSERT INTO site_content VALUES(6,'Native language','','Родной язык');
INSERT INTO site_content VALUES(7,'email','','Имя');
INSERT INTO site_content VALUES(8,'login','','логин');
INSERT INTO site_content VALUES(9,'password','','пароль');
INSERT INTO site_content VALUES(10,'repeat password','','повторите пароль');
INSERT INTO site_content VALUES(11,'Create','','Создать');

INSERT INTO site_content VALUES(12,'Add new comment','','Добавить новый комментарий');
INSERT INTO site_content VALUES(13,'Submit comment','','Отправить комментарий');
INSERT INTO site_content VALUES(14,'Comments','','Комментарии');
INSERT INTO site_content VALUES(15,'Search','','Поиск');
INSERT INTO site_content VALUES(16,'Main','','Главная');
INSERT INTO site_content VALUES(17,'Statistics','','Статистика');
INSERT INTO site_content VALUES(18,'Trainings','','Тренировки');
INSERT INTO site_content VALUES(19,'Courses','','Курсы');
INSERT INTO site_content VALUES(20,'Author','','Автор');
INSERT INTO site_content VALUES(21,'Date/time','','Дата/время');
INSERT INTO site_content VALUES(22,'Task','','Задание');
INSERT INTO site_content VALUES(23,'Complete','','Окончено');
INSERT INTO site_content VALUES(24,'User profile','','Профиль пользователя');
INSERT INTO site_content VALUES(25,'Settings','','Настройки');
INSERT INTO site_content VALUES(26,'Logout','','Выход');

-- Insertion of languages
INSERT INTO language(language_id, language_name) VALUES(1, 'English');
INSERT INTO language(language_id, language_name) VALUES(2, 'Russian');
INSERT INTO language(language_id, language_name) VALUES(3, 'French');
-- Insertion of roles
INSERT INTO role(role_id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO role(role_id, name) VALUES(2, 'ROLE_USER');
-- Insertion of user accounts
INSERT INTO user_account(user_account_id, is_enabled, is_expired, is_expired_credentials, is_locked) VALUES(1,1,0,0,0);
INSERT INTO user_account(user_account_id, is_enabled, is_expired, is_expired_credentials, is_locked) VALUES(2,1,0,0,0);
-- Insertion of users
INSERT INTO user(user_id, email, last_name, login, name, password, role_id, user_account_id, language_id) VALUES(1,'admin@gmail.com','admin','admin','admin','admin', 1, 1, 1);
INSERT INTO user(user_id, email, last_name, login, name, password, role_id, user_account_id, language_id) VALUES(2,'user@gmail.com','user','user','user','user', 2, 2, 2);

-- Insertion of messages
INSERT INTO user_message(user_message_id, date, is_critical, is_new, text, user_id_sent, user_id_recieved) VALUES(1,now(),1,1,'Hey, bro! how are you?', 1, 2);
INSERT INTO user_message(user_message_id, date, is_critical, is_new, text, user_id_sent, user_id_recieved) VALUES(2,now(),1,1,'Fine, thnx)', 2, 1);

-- Insertion of comments
INSERT INTO comment(comment_id, date, message, user_id) values(1,now(),'Comment text.', 1);