/*======================= ʹ��MLDN���ݿ� =======================*/
USE mldn ;
/*======================= ɾ��user���ݱ� =======================*/
DROP TABLE IF EXISTS user ;
/*======================= ����user���ݱ� =======================*/
CREATE TABLE user(
	userid			VARCHAR(30)		PRIMARY KEY ,
	name			VARCHAR(30)		NOT NULL ,
	password		VARCHAR(32)		NOT NULL
) ;
/*======================= ����������� =======================*/
INSERT INTO user (userid,name,password) VALUES ('admin','administrator','admin') ;
