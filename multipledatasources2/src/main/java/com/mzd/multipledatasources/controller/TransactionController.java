package com.mzd.multipledatasources.controller;

import com.mzd.multipledatasources.bean.TeachersBean;
import com.mzd.multipledatasources.bean.User;
import com.mzd.multipledatasources.service.TransactionService1;
import com.mzd.multipledatasources.service.TransactionService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RestController
public class TransactionController {
	@Autowired
	private TransactionService1 ts1;
	@Autowired
	private TransactionService2 ts2;

	@RequestMapping("/savetest.do")
	public String savetest() {
		User user = new User();
		user.setName("lxm");
		user.setAge(11);
		ts1.savetestBean(user);
		return "success";
	}

	@RequestMapping("/saveteacher.do")
	public String saveteacher() {
		TeachersBean tb = new TeachersBean();
		tb.setTeachername("王老师");
		tb.setClassid("1");
		ts2.saveTeacher(tb);
		return "success";
	}

	// ########################开始事务测试##########################
	/**
	 * 结果是一个插入进去了，属于非正常现象
	 * 
	 * @return
	 */
	@RequestMapping("/test.do")
	public String test() {
		User user = new User();
		user.setName("lxm");
		user.setAge(11);
		ts1.savetestBean2(user);
		return "success";
	}

	/**
	 * 结果是两个都没法插入---属于正常现象
	 * 
	 * @return
	 */
	@RequestMapping("/test2.do")
	public String test2() {
		User user = new User();
		user.setName("lxm");
		user.setAge(11);
		ts1.savetestBean3(user);
		return "success";
	}

	/**
	 * 结果是一个插入进去了，属于非正常现象
	 * 
	 * @return
	 */
	@RequestMapping("/test3.do")
	public String test3() {
		User user = new User();
		user.setName("lxm");
		user.setAge(11);
		ts1.savetestBean4(user);
		return "success";
	}
}
