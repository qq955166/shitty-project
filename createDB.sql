CREATE SCHEMA dlg CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON dlg.* TO 'admin'@localhost IDENTIFIED BY 'admin';

use dlg;

CREATE TABLE account (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50), password VARCHAR(50));
CREATE TABLE restaurant (id INT(11) AUTO_INCREMENT PRIMARY KEY, user_id INT(11), address VARCHAR(50), description VARCHAR(200), food_type VARCHAR(50));