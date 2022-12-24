package com.zx.entity;

import lombok.Data;

/**
 * @author : zhangxin
 * @date : 2021-08-23 10:53
 **/
@Data
public class User {

    private Integer id;

    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
}
