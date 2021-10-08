package com.zx.spring.transfer;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author : zhangxin
 * @date : 2021-09-15 17:51
 **/
public class DruidUtils {

    private DruidUtils() {
    }

    private static DruidDataSource druidDataSource = new DruidDataSource();

    static {

        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/bank");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
    }

    public static DruidDataSource getDruidDataSource() {

        return druidDataSource;
    }
}
