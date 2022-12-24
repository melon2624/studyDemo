package com.zx.stream.demo02;

import java.util.stream.Stream;

/**
 * @author zhangxin
 * @date 2022/12/22 16:14
 */
public class Demo03Stream_filter {


    public static void main(String[] args) {

        //创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");

        //对Stream流中的元素进行过滤,只要姓张的人
        Stream<String> stream1=stream.filter(s -> s.startsWith("张"));

        stream1.forEach(name-> System.out.println(name));

           /*
            Stream流属于管道流,只能被消费(使用)一次
            第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕,就会关闭了
            所以第一个Stream流就不能再调用方法了
            IllegalStateException: stream has already been operated upon or closed
         */
        //遍历stream流
        stream.forEach(name -> System.out.println(name));
    }

}
