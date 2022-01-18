package com.zx.entity;

import javax.persistence.*;


/**
 * @author  zhangxin
 * @date  2022-01-15 21:10
 */

@Table(name = "tbl_pay")
public class TblPay {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "pay_name")
    private String payName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return pay_name
     */
    public String getPayName() {
        return payName;
    }

    /**
     * @param payName
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }
}