package com.itheima.dbassist;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * ��ܵĺ�����
 * @author wzhting
 *
 */
public class DBAssist {
	private DataSource dataSource;
	public DBAssist(DataSource dataSource){
		this.dataSource = dataSource;
	}
	//д����ӡ�ɾ�����޸�
	//params����Ҫ��sql�е�ռλ����Ӧ
	public void update(String sql,Object...params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			//���ò���
				//�õ�sql�еĲ���
				ParameterMetaData pmd = stmt.getParameterMetaData();
				int count = pmd.getParameterCount();
				if(count>0){
					if(params==null){
						throw new RuntimeException("���봫�������ֵ");
					}
					if(count!=params.length){
						throw new RuntimeException("����������ƥ��");
					}
					for(int i=0;i<count;i++){
						stmt.setObject(i+1, params[i]);
					}
					
				}
			
			stmt.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			release(rs, stmt, conn);
		}
	}
	
	
	//������ѯ
	public Object query(String sql,ResultSetHandler rsh,Object...params) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement(sql);
			//���ò���
				//�õ�sql�еĲ���
				ParameterMetaData pmd = stmt.getParameterMetaData();
				int count = pmd.getParameterCount();
				if(count>0){
					if(params==null){
						throw new RuntimeException("���봫�������ֵ");
					}
					if(count!=params.length){
						throw new RuntimeException("����������ƥ��");
					}
					for(int i=0;i<count;i++){
						stmt.setObject(i+1, params[i]);
					}
					
				}
			
			rs = stmt.executeQuery();
			//�н������Ҫ��װ�������С��������ģʽ
			return rsh.handle(rs);
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			release(rs, stmt, conn);
		}
	}
	
	
	private void release(ResultSet rs,Statement stmt,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
