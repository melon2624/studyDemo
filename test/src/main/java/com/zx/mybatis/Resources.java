package com.zx.mybatis;

import java.io.InputStream;

/**
 * @author zhangxin
 * @date 2022/8/31 19:52
 */
public class Resources {

    public static InputStream getResourceAsSteam(String path) {

        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);

        return resourceAsStream;

    }

}
