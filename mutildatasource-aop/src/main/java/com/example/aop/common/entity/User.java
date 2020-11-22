package com.example.aop.common.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:15
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
}
