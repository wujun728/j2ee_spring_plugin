package com.itheima.dbassist;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 * �ʺ�ֻ��һ����ѯ��������
 * ��װ��JavaBean��
 * ����Լ�������ݿ��ֶ�����JavaBean�ֶ�������һ��
 * @author wzhting
 *
 */
public class BeanHanlder implements ResultSetHandler {
	
	private Class clazz;//Ŀ������
	public BeanHanlder(Class clazz){
		this.clazz = clazz;
	}

	public Object handle(ResultSet rs) {
		try {
			if(rs.next()){
				//�м�¼
				Object bean = clazz.newInstance();//Ŀ�����
				//�ж����У�������ֵ����ʲô��
				ResultSetMetaData rsmd = rs.getMetaData();
				int count = rsmd.getColumnCount();//����
				for(int i=0;i<count;i++){
					String fieldName = rsmd.getColumnName(i+1);//�õ����ݿ��ֶ�����Ҳ�͵õ���JavaBan���ֶ���
					Object fieldValue = rs.getObject(fieldName);//�ֶ�ֵ
					//ͨ���ֶη���
					Field f = clazz.getDeclaredField(fieldName);
					f.setAccessible(true);
					f.set(bean, fieldValue);
				}
				return bean;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
