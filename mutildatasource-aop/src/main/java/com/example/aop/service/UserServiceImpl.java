package com.example.aop.service;

import com.example.aop.annotation.DataSourceSign;
import com.example.aop.common.ContextConst;
import com.example.aop.common.entity.User;
import com.example.aop.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;
    @DataSourceSign(ContextConst.PRIMARY)
    @Override
    @Transactional
    public User saveToDB1(User user) {
        return userRespository.save(user);
    }
    @DataSourceSign(ContextConst.LOCAL)
    @Override
    @Transactional
    public User saveToDB2(User user) {
        User user1 = new User();
        user1.setName("娃哈哈");
        user1.setAge(20);
        saveToDB1(user1);
        int i = 1/0;
        return userRespository.save(user);
    }
}
