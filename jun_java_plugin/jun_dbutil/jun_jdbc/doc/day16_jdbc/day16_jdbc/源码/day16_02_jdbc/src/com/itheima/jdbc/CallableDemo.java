package com.itheima.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import org.junit.Test;

import com.itheima.util.JdbcUtil;

/*
delimiter $$

CREATE PROCEDURE demoSp(IN inputParam VARCHAR(255), INOUT inOutParam varchar(255))
BEGIN
    SELECT CONCAT('zyxw---', inputParam) into inOutParam;
END $$

delimiter ;
 */

//��ε����Ѿ����ڵĴ洢����
public class CallableDemo {
	@Test
	public void test1() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		CallableStatement stmt = conn.prepareCall("{call demoSp(?,?)}");
		//�������������ֵ
		//���������ע���������ͼ���
		stmt.setString(1, "YY");
		stmt.registerOutParameter(2, Types.VARCHAR);
		
		stmt.execute();
		//��ӡִ�еĽ��
		System.out.println(stmt.getString(2));
		JdbcUtil.release(null, stmt, conn);
	}
}
