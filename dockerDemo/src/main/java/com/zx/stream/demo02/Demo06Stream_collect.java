package com.zx.stream.demo02;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream流的收集方法
 * R collect(Collector collector)
 * <p>
 * 它是通过工具类Collectors提供了具体的收集方式
 * public static <T> Collector toList()：把元素收集到List集合中
 * public static <T> Collector toSet()：把元素收集到Set集合中
 * public static Collector toMap(Function keyMapper,Function valueMapper)：把元素收集到Map集合中
 * 需求1：得到名字为3个字的流
 * 需求2：把使用Stream流操作完毕的数据收集到List集合中并遍历
 * 需求3：得到年龄大于25的流
 * 需求4：把使用Stream流操作完毕的数据收集到Set集合中并遍历
 * 需求5：得到字符串中年龄数据大于28的流
 * 需求6：把使用Stream流操作完毕的数据收集到Map集合中并遍历，字符串中的姓名作键，年龄作值
 *
 * @author zhangxin
 * @date 2022/12/23 8:41
 */
public class Demo06Stream_collect {

    public static void main(String[] args) {

        //创建List集合对象
        List<String> list = new ArrayList<String>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("乔欣");
        list.add("杨紫");

        //需求1：得到名字为3个字的流
        Stream<String> listStream = list.stream().filter(s -> s.length() == 3);

        //需求2：把使用Stream流操作完毕的数据收集到List集合中并遍历
        List<String> names = listStream.collect(Collectors.toList());

        for (String name : names) {
            System.out.println(name);
        }

        //创建Set集合对象
        Set<Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);

        //需求3：得到年龄大于25的流
        Stream<Integer> setStream = set.stream().filter(age -> age > 25);

        //需求4：把使用Stream流操作完毕的数据收集到Set集合中并遍历
        Set<Integer> ageSet = setStream.collect(Collectors.toSet());

        for (Integer age : ageSet) {
            System.out.println(age);
        }

        System.out.println("-------------------------------------");

        //定义一个字符串数组，每一个字符串数据由姓名数据和年龄数据组合而成
        String[] strArray = {"林青霞,30", "张曼玉,35", "王祖贤,33", "柳岩,25"};

        //需求5：得到字符串中年龄数据大于28的流
        Stream<String> arrStream = Stream.of(strArray).filter(s -> Integer.parseInt(s.split(",")[1]) > 28);

        //需求6：把使用Stream流操作完毕的数据收集到Map集合中并遍历，字符串中的姓名作键，年龄作值

        Map<String, Integer> map = arrStream.collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));


        /*Set<String> keySet = map.keySet();
        for (String key:keySet){
            System.out.println(key+"  :"+map.get(key));
        }*/


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :" + entry.getValue());
        }


    }

}
