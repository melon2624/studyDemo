package com.zx.coupon.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zx.coupon.dao.converter.CouponTypeConverter;
import com.zx.coupon.template.api.bean.rules.TemplateRule;
import com.zx.coupon.template.api.enums.CouponType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 优惠券模板
 * @TableName coupon_template
 * @author zhangxin
 * @date 2022/11/14 18:44
 */
@TableName(value ="coupon_template")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplate {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 优惠券可用状态
     */
    @TableField(value = "available")
    private Integer available;

    /**
     * 优惠券名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 优惠券详细信息
     */
    @TableField(value = "description")
    private String description;

 /*   // 优惠券类型
    @Column(name = "type")
    private CouponType category;*/

    /**
     * 优惠券类型，比如满减、随机立减、晚间双倍等等
     */
    @TableField(value = "type")
    private String type;

    /**
     * 优惠券适用的门店，如果是空则代表全场适用
     */
    @TableField(value = "shop_id")
    private Long shop_id;

    /**
     * 创建时间
     */
    @TableField(value = "created_time")
    private Date created_time;

    /**
     * 详细的使用规则
     */
    // 优惠券核算规则，平铺成JSON字段
    @Column(name = "rule", nullable = false)
    private TemplateRule rule;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
