package com.itheima.dbassist;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * ��װ��JavaBean��
 * ����Լ�������ݿ��ֶ�����JavaBean�ֶ�������һ��
 * @author wzhting
 *
 */
public class BeanListHanlder implements ResultSetHandler {
	
	private Class clazz;//Ŀ������
	public BeanListHanlder(Class clazz){
		this.clazz = clazz;
	}

	public Object handle(ResultSet rs) {
		try {
			List list = new ArrayList();
			while(rs.next()){
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
				list.add(bean);
			}
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
