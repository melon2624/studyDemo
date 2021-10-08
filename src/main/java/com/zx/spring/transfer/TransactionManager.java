package com.zx.spring.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author : zhangxin
 * @date : 2021-09-15 17:48
 **/
@Component
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    /*public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }*/

    // 开启手动事务控制
    public void beginTransaction() throws SQLException {
        connectionUtils.getCurrentThreadConn().setAutoCommit(false);
    }

    //提交事务
    public void commit() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
    }

    //回滚事务
    public void rollback() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
    }

}
