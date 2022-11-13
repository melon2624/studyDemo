package com.zx.enum1;

/**
 * @author zhangxin
 * @date 2022/10/15 14:36
 */
public enum ColorEnum {

    RED("zx", "2"), BLACK("zm", "3");

    private ColorEnum(String name, String age) {
        System.out.println("zhangxin6666666"+this);
    }

}
