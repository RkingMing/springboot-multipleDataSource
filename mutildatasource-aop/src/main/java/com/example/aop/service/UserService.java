package com.example.aop.service;

import com.example.aop.common.entity.User;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:19
 */
public interface UserService {
    User saveToDB1(User user);
    User saveToDB2(User user);
    void test();
}
