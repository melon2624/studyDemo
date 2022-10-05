package com.zx.other;

/**
 * @author zhangxin
 * @date 2022/9/19 17:33
 */
public class StringUtils {

    public static boolean isAvailable(String val) {
        if (val == null) {
            return false;
        } else {
            return val.length() != 0;
        }
    }


    public static void main(String[] args) {
        Boolean flag = StringUtils.isAvailable("    ");
        String iii="    ".trim();
        int length = "   ".length();
        System.out.println(length);



    }


}
