package com.example.aop.respository;

import com.example.aop.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:17
 */
public interface UserRespository extends JpaRepository<User,Long> {
}
