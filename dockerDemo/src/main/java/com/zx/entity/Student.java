package com.zx.entity;

import lombok.Data;

/**
 * @author zhangxin
 * @date 2022/12/22 16:27
 */
@Data
public class Student {

    String name;

    Integer age;

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public Student(){

    }


}
