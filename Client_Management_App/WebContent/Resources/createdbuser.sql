--Normal sql commands for creating user


CREATE USER 'clientManager'@'localhost' IDENTIFIED BY 'clientManager';

GRANT ALL PRIVILEGES ON * . * TO 'clientManager'@'localhost';


ALTER USER 'clientManager'@'localhost' IDENTIFIED WITH mysql_native_password BY '********';