package com.zx.stream.demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * JDK8 Stream API:
 * https://docs.oracle.com/javase/8/docs/api/index.html
 * 使用传统的方式,遍历集合,对集合中的数据进行过滤
 * 查找集合中姓张的人
 * 再筛选出张姓中名字有三个字的人
 * 最后打印出来
 *
 * @author zhangxin
 * @date 2022/12/22 11:24
 */
public class DemoList {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张鑫");
        list.add("张三丰");

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        List<String> listA = new ArrayList<>();

        for (String s : list) {
            if (s.startsWith("张")) {
                listA.add(s);
            }
        }

        for (String s : listA) {
            System.out.println(s);
        }

        System.out.println("---------------------------");

        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        List<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length() == 3) {
                listB.add(s);
            }
        }
        //遍历listB集合
        for (String s : listB) {
            System.out.println(s);
        }

        System.out.println("-----------------------------stream");

        // 使用Stream实现
        Stream<String> stream = list.stream();
        stream.filter(name->name.startsWith("张")).filter(name->name.length()==3)
                .forEach(name -> System.out.println(name));

        //stream.limit(1); // java.lang.IllegalStateException: stream has already been operated upon or closed

    }


}
