package com.zx.basic;

import com.zx.entity.Student;

import java.util.Comparator;

/**
 * @author : zhangxin
 * @date : 2021-12-07 17:58
 **/
public class Compare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}
