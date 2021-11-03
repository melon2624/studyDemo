package com.zx.other;

import com.zx.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zhangxin
 * @date : 2021-11-03 17:37
 **/
public class Test {

    public static void main(String[] args) {

        Student s1 = new Student(1, "zx", 24);
        Student s2 = new Student(2, "zm", 19);
        Student s3 = new Student(3, "gm", 25);
        Student s4 = new Student(4, "gj", 30);
        Student s5 = new Student(5, "xx", 10);

        List<Student> studentList = new ArrayList<>();

        studentList.add(s2);
        studentList.add(s1);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        Collections.sort(studentList, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });

        for (Student student : studentList) {
            System.out.println(student.toString());
        }

    }


}
