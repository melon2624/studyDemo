package com.zx.multithread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhangxin
 * @date : 2021-10-25 14:02
 **/
public class ImmutableExample1 {

    private  final  static  Integer a=1;
    private final  static  Integer b=2;
    private  final  static Map<Integer,Integer> map=new HashMap<>();

    static  {
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
    }

    public static void main(String[] args) {
            map.put(1,3);

        System.out.println(map.get(1));
    }

}
