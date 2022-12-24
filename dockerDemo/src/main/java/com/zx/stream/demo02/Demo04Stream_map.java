package com.zx.stream.demo02;

import com.zx.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhangxin
 * @date 2022/12/22 16:18
 */
public class Demo04Stream_map {

    public static void main(String[] args) {

        //获取一个String类型的Stream流
        Stream<String> stream = Stream.of("1", "2", "3", "4");

        //使用map方法,把字符串类型的整数,转换(映射)为Integer类型的整数
        stream.map(s -> Integer.parseInt(s)).forEach(integer -> System.out.println(integer));


        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("zhangxin",25));
        studentList.add(new Student("zhangmiao",22));
        studentList.add(new Student("guanmengtao",26));
        studentList.add(new Student("xiaolv",20));

        List<Integer> collect = studentList.stream().map(Student::getAge).collect(Collectors.toList());

        System.out.println(collect);

    }

}
