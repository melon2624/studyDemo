package com.zx.other;

import java.math.BigDecimal;

/**
 * @author zhangxin
 * @date 2022/9/27 20:27
 */
public class Test2 {

    public static void main(String[] args) {

        // String aaa=(new BigDecimal(222.3).subtract(new BigDecimal(190)));

      /*  BigDecimal a1=new BigDecimal(a);
        BigDecimal a2=new BigDecimal(b);
        strings[1] =a1.compareTo(new BigDecimal(190))>1?(new BigDecimal(360).subtract(a1)).toString():a1.toString();
        strings[2] =a2.compareTo(new BigDecimal(190))>1?(new BigDecimal(360).subtract(a2)).toString():a2.toString();*/
        String a1 = "222.3";
        Double a = Double.parseDouble(a1);
        double b = (a - 194.0);
        if (b>0){

        }
        System.out.println(b);

    }

}
