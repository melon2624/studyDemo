package com.zx.spring.transfer;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author : zhangxin
 * @date : 2021-09-15 17:48
 **/
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal=new ThreadLocal<>();


    public Connection getCurrentThreadConn() throws SQLException {

        Connection connection=threadLocal.get();
        if (connection==null){
            connection=DruidUtils.getDruidDataSource().getConnection();
            threadLocal.set(connection);
        }

        return connection;

    }
}
