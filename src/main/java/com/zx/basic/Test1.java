package com.zx.basic;

import com.zx.entity.Student;

import java.util.Random;

/**
 * @author : xkdtm
 * @date : 2021-12-07 17:59
 **/
public class Test1 {

    public static void main(String[] args) {

        Student s1 = new Student(1, "zx", 24);

        Student s2 = new Student(2, "zm", 19);

        Compare compare=new Compare();
        System.out.println(compare.compare(s2,s2));

        Random random = new Random();

        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        System.out.println(rannum);
    }
}
