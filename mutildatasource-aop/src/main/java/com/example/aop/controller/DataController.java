package com.example.aop.controller;

import com.example.aop.common.entity.User;
import com.example.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:29
 */
@RestController
public class DataController {

    @Autowired
    private UserService parmaryUserService;

    @RequestMapping("/test/{type}")
    public User login(@PathVariable Integer type) {
        User user = new User();
        switch (type) {
            case 1:
                user.setAge(10);
                user.setName("zs");
                return parmaryUserService.saveToDB1(user);
            case 2:
                user.setAge(30);
                user.setName("ls");
                return parmaryUserService.saveToDB2(user);
            default:
                break;
        }
        return user;
    }

    @GetMapping("/test")
    public void test(){
        parmaryUserService.test();
    }
}
