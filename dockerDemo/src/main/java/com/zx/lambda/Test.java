package com.zx.lambda;

import com.zx.entity.Student;

import java.util.Optional;

/**
 * @author zhangxin
 * @date 2023/1/10 8:52
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();

        student.setName("zhangxin");
        String s = Optional.ofNullable(student).map(Student::getName).orElse("88888");
        System.out.println(s);

    }

}
