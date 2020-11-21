package com.mzd.multipledatasources.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.mapper.test02.TransactionMapping2;

@Service
public class TransactionService2 {
	@Autowired
	private TransactionMapping2 tp2;

	@Transactional
	public void saveTeacher(TeachersBean t) {
		tp2.save(t);
	}

	@Transactional
	public void saveTeacher2(TeachersBean t) {
		int i = 1 / 0;
		tp2.save(t);
	}
}
