/*======================= ɾ�����ݿ� =======================*/
DROP DATABASE IF EXISTS mldn ;
/*======================= �������ݿ� =======================*/
CREATE DATABASE mldn ;
/*======================= ʹ�����ݿ� =======================*/
USE mldn ;
/*======================= ɾ�����ݱ� =======================*/
DROP TABLE IF EXISTS emp ;
/*======================= �������ݱ� =======================*/
CREATE TABLE emp(
   empno			INT(4)			PRIMARY KEY,
   ename			VARCHAR(10),
   job				VARCHAR(9),
   hiredate			DATE,
   sal				FLOAT(7,2)
) ;
/*======================= ����������� =======================*/
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (6060,'���˻�','����','2001-09-16',2000.30) ;
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (7369,'�����','����','2003-10-09',1500.90) ;
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (8964,'����','����Ա','2003-10-01',3000) ;
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (7698,'�Ż�','����','2005-03-12',800) ;
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (7782,'���','����Ա','2005-01-12',2500) ;
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (7762,'����','����','2005-03-09',1000) ;
INSERT INTO emp (empno,ename,job,hiredate,sal) VALUES (7839,'����','����','2006-09-01',2500) ;
