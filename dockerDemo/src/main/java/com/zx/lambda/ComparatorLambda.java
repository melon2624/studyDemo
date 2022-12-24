package com.zx.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangxin
 * @date 2022/12/21 11:03
 */
public class ComparatorLambda {

    public static void main(String[] args) {

        String[] strs={"dihws","wwsedwsdf","aa","qwer"};

        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
   /*     Arrays.sort(strs,comparator);
        System.out.println(Arrays.toString(strs));*/

        Arrays.sort(strs,(o1,o2)->{
            return o1.length()-o2.length();
        });

        System.out.println(Arrays.toString(strs));



    }

}
