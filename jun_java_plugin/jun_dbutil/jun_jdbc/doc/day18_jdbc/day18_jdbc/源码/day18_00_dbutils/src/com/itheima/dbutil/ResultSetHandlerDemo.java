package com.itheima.dbutil;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.itheima.util.DBCPUtil;

public class ResultSetHandlerDemo {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	//ArrayHandler:�ʺϽ��ֻ��һ����������ѵ�һ����¼��ÿ�е�ֵ��װ��һ��Object[]������
	@Test
	public void test1() throws Exception{
		Object[] objs = qr.query("select * from student", new ArrayHandler());
		for(Object obj:objs)
			System.out.println(obj);
	}
	//ArrayListHandler:�ʺϽ���ж������������ÿ�е�ֵ��װ��Object[]�����У���Object[]�ŵ�List��
	@Test
	public void test2() throws Exception{
		List<Object[]> list = qr.query("select * from student", new ArrayListHandler());
		for(Object[] objs:list){
			System.out.println("----------------");
			for(Object obj:objs){
				System.out.println(obj);
			}
		}
	}
	//ColumnListHandler:�ʺ�ȡĳ�е�ֵ����ȡ��ֵ��װ��List��
	@Test
	public void test3() throws Exception{
		List<Object> list = qr.query("select * from student", new ColumnListHandler("name"));
		for(Object obj:list){
			System.out.println(obj);
		}
	}
	//KeyedHandler:��ѯ������¼��ÿ����¼��װ��һ��Map�У�key���ֶ�����value���ֶ�ֵ���ٰ�Map��Ϊvalue�ŵ�����һ��Map�У���Map��keyΪָ������ֵ��Ϊkey��
	@Test
	public void test4() throws Exception{
		Map<Object,Map<String,Object>> bmap = qr.query("select * from student", new KeyedHandler("id"));
		for(Map.Entry<Object,Map<String,Object>> bme:bmap.entrySet()){
			System.out.println("--------------------");
			for(Map.Entry<String, Object> lme:bme.getValue().entrySet()){
				System.out.println(lme.getKey()+"="+lme.getValue());
			}
		}
	}
	//MapHandler:�ʺ�һ���������װ��һ��Map�У�key���ֶ�����value���ֶ�ֵ
	@Test
	public void test5() throws Exception{
		Map<String,Object> map = qr.query("select * from student", new MapHandler());
		for(Map.Entry<String, Object> lme:map.entrySet()){
			System.out.println(lme.getKey()+"="+lme.getValue());
		}
	}
	//MapListHandler:�ʺ϶����������ÿ����װ��һ��Map�У�key���ֶ�����value���ֶ�ֵ���ڰ�Map��װ��List��
	@Test
	public void test6() throws Exception{
		List<Map<String,Object>> list = qr.query("select * from student", new MapListHandler());
		for(Map<String,Object> map:list){
			System.out.println("--------------------");
			for(Map.Entry<String, Object> lme:map.entrySet()){
				System.out.println(lme.getKey()+"="+lme.getValue());
			}
		}
	}
	//ScalarHandler:�ʺ�ȡ���ֻ��һ�к�һ�е������
	@Test
	public void test7() throws Exception{
		Object obj = qr.query("select count(*) from student", new ScalarHandler(1));
//		System.out.println(obj.getClass().getName());
		Long l = (Long)obj;
		System.out.println(l.intValue());
		System.out.println(obj);
	}
}
