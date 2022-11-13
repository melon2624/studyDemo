package com.zx.coupon.customer.service;

import com.zx.coupon.customer.dao.entity.Coupon;
import com.zx.coupon.template.api.CouponInfo;

/**
 * @author zhangxin
 * @date 2022/11/11 11:28
 */
public class CouponConverter {

    public static CouponInfo convertToCoupon(Coupon coupon) {

        return CouponInfo.builder()
                .id(coupon.getId())
                .status(coupon.getStatus().getCode())
                .templateId(coupon.getTemplateId())
                .shopId(coupon.getShopId())
                .userId(coupon.getUserId())
                .template(coupon.getTemplateInfo())
                .build();
    }
}
