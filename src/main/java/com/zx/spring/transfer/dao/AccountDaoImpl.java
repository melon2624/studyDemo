package com.zx.spring.transfer.dao;

import com.zx.entity.Account;
import com.zx.spring.transfer.ConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author : zhangxin
 * @date : 2021-09-15 20:18
 **/
@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {

        Connection connection = connectionUtils.getCurrentThreadConn();

        String sql = "select * from account where cardNo=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();

        while (resultSet.next()) {
            account.setCardNo(resultSet.getString("cardNo"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getInt("money"));
        }

        resultSet.close();
        preparedStatement.close();

        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {

        Connection connection = connectionUtils.getCurrentThreadConn();
        String sql = "update account set money=? where cardNo=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, account.getMoney());
        preparedStatement.setString(2, account.getCardNo());
        int i = preparedStatement.executeUpdate();

        preparedStatement.close();

        return i;
    }
}
