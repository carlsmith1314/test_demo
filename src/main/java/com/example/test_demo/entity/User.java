package com.example.test_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//TODO 编译器自动加载get/set方法
@Data

//TODO 编译器自动加载无参构造方法
@NoArgsConstructor

//TODO 编译器自动加载包含所有参数的构造方法
@AllArgsConstructor

public class User {
    //todo 姓名
    String name;
    //todo 性别
    String sex;
    //todo 年龄
    int age;
    //todo 地址
    String address;
    //todo 关系
    String relation;

    /**
     * 构造方法
     * @param name
     * @param address
     */
    public User(String name, String address){
        this.name = name;
        this.address = address;
    }
}
