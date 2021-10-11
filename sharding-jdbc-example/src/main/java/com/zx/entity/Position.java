package com.zx.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zhangxin
 * @date 2021/10/11 1:26
 */
@Data
public class Position {

    @Id
    @Column(name = "`id`")
    private Integer id;

    private String name;

    private String salary;

    private String city;
}