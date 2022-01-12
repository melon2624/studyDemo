package com.zx.entity;


import java.util.Date;
import javax.persistence.*;


/**
 * @author  zhangxin
 * @date  2022-01-13 2:01
 */

@Table(name = "tbl_order_event")
public class TblOrderEvent {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 事件类型（支付表支付完成，订单表修改状态）
     */
    @Column(name = "orderType")
    private String ordertype;

    /**
     * 事件环节（new,published,processed)
     */
    @Column(name = "`process`")
    private String process;

    /**
     * 事件内容，保存事件发生时需要传递的数据
     */
    @Column(name = "content")
    private String content;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "updateTime")
    private Date updatetime;

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
     * 获取事件类型（支付表支付完成，订单表修改状态）
     *
     * @return orderType - 事件类型（支付表支付完成，订单表修改状态）
     */
    public String getOrdertype() {
        return ordertype;
    }

    /**
     * 设置事件类型（支付表支付完成，订单表修改状态）
     *
     * @param ordertype 事件类型（支付表支付完成，订单表修改状态）
     */
    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    /**
     * 获取事件环节（new,published,processed)
     *
     * @return process - 事件环节（new,published,processed)
     */
    public String getProcess() {
        return process;
    }

    /**
     * 设置事件环节（new,published,processed)
     *
     * @param process 事件环节（new,published,processed)
     */
    public void setProcess(String process) {
        this.process = process;
    }

    /**
     * 获取事件内容，保存事件发生时需要传递的数据
     *
     * @return content - 事件内容，保存事件发生时需要传递的数据
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置事件内容，保存事件发生时需要传递的数据
     *
     * @param content 事件内容，保存事件发生时需要传递的数据
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}