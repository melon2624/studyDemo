package com.zx.coupon.customer.dao.servie;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.coupon.customer.dao.entity.Coupon;

/**
 * @author zhangxin
 * @date 2022/11/14 9:58
 */
public interface CouponService extends IService<Coupon> {

    long countByUserIdAndTemplateId(Long userId, Long templateId);

}
