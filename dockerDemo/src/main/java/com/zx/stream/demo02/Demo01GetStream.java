package com.zx.stream.demo02;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author zhangxin
 * @date 2022/12/22 13:39
 */
public class Demo01GetStream {


    public static void main(String[] args) {

        //把集合转换为stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String, String> map = new HashMap<>();
        //获取键,存储到一个Set集合中
        Set<String> ketSet = map.keySet();
        Stream<String> stream3 = ketSet.stream();

        //获取值,存储到一个Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        //获取键值对(键与值的映射关系 entrySet)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        Integer[] arr = {1, 2, 3, 4, 5};

        String[] arr2 = {"a", "bb", "ccc"};

        Stream<Integer> stream6 = Stream.of(arr);
        Stream<String> stream7 = Stream.of(arr2);


    }


}
