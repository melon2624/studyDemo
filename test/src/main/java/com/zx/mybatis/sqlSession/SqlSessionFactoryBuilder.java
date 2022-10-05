package com.zx.mybatis.sqlSession;

import com.zx.mybatis.XMLConfigBuilder;
import com.zx.mybatis.pojo.Configuration;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author zhangxin
 * @date 2022/8/31 20:09
 */
public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {
        // 第一：使用dom4j解析配置文件，将解析出来的内容封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);


        return null;
    }

}
