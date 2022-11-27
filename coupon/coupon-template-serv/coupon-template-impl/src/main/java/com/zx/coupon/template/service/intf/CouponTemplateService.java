package com.zx.coupon.template.service.intf;

import com.zx.coupon.template.api.bean.CouponTemplateInfo;

/**
 * @author zhangxin
 * @date 2022/11/14 18:35
 */
public interface CouponTemplateService {

    // 通过模板ID查询优惠券模板
    CouponTemplateInfo loadTemplateInfo(Long id);

}
