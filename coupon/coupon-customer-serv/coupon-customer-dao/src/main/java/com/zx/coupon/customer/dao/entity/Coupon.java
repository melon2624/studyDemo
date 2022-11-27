package com.zx.coupon.customer.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zx.coupon.template.api.bean.CouponTemplateInfo;
import com.zx.coupon.template.api.enums.CouponStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @author zhangxin
 * @date 2022/11/10 16:37
 */

@TableName(value = "`coupon`")
@Data
@Builder
public class Coupon {

    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    // 对应的模板ID - 不使用one to one映射
    // 不推荐使用级联查询的原因是为了防止滥用而导致的DB性能问题
    @TableField(value = "template_id")
    private Long templateId;

    // 所有者的用户ID
    @TableField(value = "user_id")
    private Long userId;

    // 冗余一个shop id方便查找
    @TableField(value = "shop_id")
    private Long shopId;

    // 优惠券的使用/未使用状态
    @TableField(value = "status")
    private CouponStatus status;

    // 被Transient标记的属性是不会被持久化的
    @Transient
    private CouponTemplateInfo templateInfo;

    @TableField(value = "created_time")
    private Date createdTime;

}
