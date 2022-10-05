package com.zx.desgin.Prototype;

/**
 * @author zhangxin
 * @date 2022/9/15 9:49
 */
public class JinGuBang {

    public float h = 100;
    public float d = 10;


    public void big() {
        this.d *= 2;
        this.h *= 2;
    }

    public void small() {
        this.d /= 2;
        this.h /= 2;
    }

}
