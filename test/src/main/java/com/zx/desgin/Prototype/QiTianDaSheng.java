package com.zx.desgin.Prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangxin
 * @date 2022/9/15 9:50
 */
public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {

    private JinGuBang jinGuBang;

    public QiTianDaSheng() {
        //只是初始化
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return null;
    }


}
