package com.zx.stream.demo02;

import java.util.stream.Stream;

/**
 * @author zhangxin
 * @date 2022/12/24 8:47
 */
public class Demo08Stream_concat {

    public static void main(String[] args) {

        //创建一个Stream流
        Stream<String> stream1 = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
        //获取一个Stream流
        String[] arr = {"美羊羊","喜洋洋","懒洋洋","灰太狼","红太狼"};
        Stream<String> stream2 = Stream.of(arr);

        Stream.concat(stream1,stream2).forEach(s -> System.out.println(s));

    }

}
