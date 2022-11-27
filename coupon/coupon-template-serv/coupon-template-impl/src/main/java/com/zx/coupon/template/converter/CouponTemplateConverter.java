package com.zx.coupon.template.converter;

import com.zx.coupon.dao.entity.CouponTemplate;
import com.zx.coupon.template.api.bean.CouponTemplateInfo;

/**
 * @author zhangxin
 * @date 2022/11/14 19:30
 */

public class CouponTemplateConverter {

    public static CouponTemplateInfo convertToTemplateInfo(CouponTemplate template) {

        return CouponTemplateInfo.builder()
                .id(template.getId())
                .name(template.getName())
                .desc(template.getDescription())
                .type(template.getType())
                .shopId(template.getShop_id())
                .available(template.getAvailable()==0)
                .rule(template.getRule())
                .build();
    }

}
