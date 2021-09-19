package com.jun.plugin.oa.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jun.plugin.oa.entity.Salary;
import com.jun.plugin.oa.service.ISalaryService;

@Service
//@Qualifier("salaryService")
public class SalaryServiceImpl extends BaseServiceImpl<Salary> implements ISalaryService {

	
	@Override
	public Serializable doAdd(Salary salary) throws Exception {
		return add(salary);
	}

	@Override
	public void doUpdate(Salary salary) throws Exception {
		update(salary);
	}

	@Override
	public Salary findByUserId(String userId) throws Exception {
		return getUnique("Salary", new String[]{"userId"}, new String[]{userId});
	}

	@Override
	public Salary findById(Integer id) throws Exception {
		return getUnique("Salary",new String[]{"id"}, new String[]{id.toString()});
	}

}
