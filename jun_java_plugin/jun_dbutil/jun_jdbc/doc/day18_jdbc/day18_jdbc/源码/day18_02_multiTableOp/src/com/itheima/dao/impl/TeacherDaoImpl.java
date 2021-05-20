package com.itheima.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Student;
import com.itheima.domain.Teacher;
import com.itheima.util.DBCPUtil;

public class TeacherDaoImpl {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	public void saveTeacher(Teacher t){
		try{
		//������ʦ�Ļ�����Ϣ
			qr.update("insert into teachers values(?,?,?)", t.getId(),t.getName(),t.getSalary());
		//�鿴��ʦ��û�й�����ѧ����Ϣ
			List<Student> students = t.getStudents();
		//����У�����
			for(Student s:students){
				//�Ȳ�ѯѧ����Ϣ�Ƿ��Ѿ�����
				Student dbStudent = qr.query("select * from students where id=?", new BeanHandler<Student>(Student.class),s.getId());
					//�����ڣ�����ѧ����Ϣ
				if(dbStudent==null){
					qr.update("insert into students values (?,?,?)", s.getId(),s.getName(),s.getGrade());
				}
				//�ڵ��������н�������
				qr.update("insert into teachers_students values(?,?)", t.getId(),s.getId());
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public Teacher findTeacherById(int teacherId){
		try{
			Teacher t = qr.query("select * from teachers where id=?", new BeanHandler<Teacher>(Teacher.class),teacherId);
			if(t!=null){
//				String sql = "select * from students where id in (select s_id from teachers_students where t_id=?)";
//				String sql = "select * from students s,teachers_students ts where s.id=ts.s_id and ts.t_id=?";
				String sql = "select * from students s inner join teachers_students ts on s.id=ts.s_id where ts.t_id=?";
				List<Student> students = qr.query(sql, new BeanListHandler<Student>(Student.class),teacherId);
				t.setStudents(students);
			}
			return t;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
