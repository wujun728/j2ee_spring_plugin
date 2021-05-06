package com.itheima.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.itheima.util.JdbcUtil;

//�����ݵĴ�ȡ
public class LobDemo {
	/*
	 create table t2(
	 	id int,
	 	content longtext
	 );
	 */
	@Test
	public void test1() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into t2 values (?,?)");
		stmt.setInt(1, 1);
		//�����ķ�ʽ
		File file = new File("src/jpm.txt");
		Reader reader = new FileReader(file);
		stmt.setCharacterStream(2, reader, (int)file.length());//PreparedStatement��ʵ���������ݿ������ṩ��
															//MySQL:setCharacterStream(int,Reader,long);����û��ʵ�֡�
															//MySQL������֧����ô������ݡ�
		stmt.executeUpdate();
		JdbcUtil.release(null, stmt, conn);
	}
	
	//ȡ���ı�����
	@Test
	public void test2() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from t2 where id=1");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			Reader r = rs.getCharacterStream("content");
			//���ݱ���D�̵�1.txt�ļ���
			Writer w = new FileWriter("d:/1.txt");
			int len = -1;
			char c[] = new char[1024];
			while((len=r.read(c))!=-1){
				w.write(new String(c), 0, len);
			}
			r.close();
			w.close();
		}
		JdbcUtil.release(rs, stmt, conn);
	}
	
	/*
	 create table t3(
	 	id int,
	 	content longblob
	 );
	 */
	@Test
	public void test3() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("insert into t3 values (?,?)");
		stmt.setInt(1, 1);
		//�����ķ�ʽ
		InputStream in = new FileInputStream("src/26.jpg");
		
		stmt.setBinaryStream(2, in, in.available());
		stmt.executeUpdate();
		JdbcUtil.release(null, stmt, conn);
	}
	@Test
	public void test4() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from t3 where id=1");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			InputStream in = rs.getBinaryStream("content");
			OutputStream out = new FileOutputStream("d:/wife.jpg");
			
			int len = -1;
			byte b[] = new byte[1024];
			while((len=in.read(b))!=-1){
				out.write(b,0,len);
			}
			in.close();
			out.close();
		}
		JdbcUtil.release(null, stmt, conn);
	}
}
