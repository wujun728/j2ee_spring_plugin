package com.itheima.dbassist;

import java.sql.ResultSet;

public interface ResultSetHandler {
	/**
	 * �ѽ���е����ݷ�װ��ָ���Ķ�����
	 * @param rs
	 * @return ��װ�����ݵĶ���
	 */
	Object handle(ResultSet rs);
}
