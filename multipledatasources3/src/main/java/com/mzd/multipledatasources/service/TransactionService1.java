package com.mzd.multipledatasources.service;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.TestBean;
import com.mzd.multipledatasources.mapper.test01.TransactionMapping1;
import com.mzd.multipledatasources.mapper.test02.TransactionMapping2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@SuppressWarnings("all")
public class TransactionService1 {
	@Autowired
	private TransactionMapping1 tp1;
	@Autowired
	private TransactionService2 ts2;
	@Autowired
	private TransactionMapping2 tp2;

	@Transactional
	public void savetestBean(TestBean t) {
		tp1.save(t);
	}

	@Transactional
	public void savetestBean2(TestBean t) {
		TeachersBean tb = new TeachersBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setTeachername("王老师");
		tb.setClassid("1");
		ts2.saveTeacher(tb);
		int i = 1 / 0;
		tp1.save(t);
	}

	@Transactional
	public void savetestBean3(TestBean t) {
		TeachersBean tb = new TeachersBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setTeachername("王老师");
		tb.setClassid("1");
		ts2.saveTeacher2(tb);
		int i = 1 / 0;
		tp1.save(t);
	}


	/**
	 * 直接注入数据源2的dao层就不收这个事务控制了
	 * 
	 * @param t
	 */
	@Transactional
	public void savetestBean4(TestBean t) {
		TeachersBean tb = new TeachersBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setTeachername("王老师");
		tb.setClassid("1");
		tp2.save(tb);
		int i = 1 / 0;
		tp1.save(t);
	}

}
