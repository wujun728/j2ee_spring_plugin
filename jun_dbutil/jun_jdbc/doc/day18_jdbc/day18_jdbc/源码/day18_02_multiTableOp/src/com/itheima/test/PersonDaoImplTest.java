package com.itheima.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itheima.dao.impl.PersonDaoImpl;
import com.itheima.domain.IdCard;
import com.itheima.domain.Person;

public class PersonDaoImplTest {
	private PersonDaoImpl dao = new PersonDaoImpl();
	@Test
	public void testSavePerson() {
		Person p = new Person();
		p.setId(1);
		p.setName("Τ��ͣ");
		
		IdCard idcard = new IdCard();
		idcard.setNum("4101");
		
		//������ϵ
		p.setIdcard(idcard);
		
		dao.savePerson(p);
	}

	@Test
	public void testFindPersonById() {
		Person p = dao.findPersonById(1);
		System.out.println(p.getName()+"���֤�ţ�"+p.getIdcard().getNum());
	}

}
