package com.zx.coupon.template.api.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author zhangxin
 * @date 2022/11/11 14:02
 */
/**
 * 封装优惠券信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponInfo {

    private Long id;

    private Long templateId;

    private Long userId;

    private Long shopId;

    private Integer status;

    private CouponTemplateInfo template;
}
