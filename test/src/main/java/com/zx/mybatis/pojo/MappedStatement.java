package com.zx.mybatis.pojo;

import lombok.Data;

/**
 * @author zhangxin
 * @date 2022/8/31 19:56
 */
@Data
public class MappedStatement {

    //id
    private String id;

    //sql语句
    private String sql;

    //返回值类型
    private String resultType;

    //参数值类型
    private String paramterType;


}
