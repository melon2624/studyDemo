package com.zx.coupon.customer.service.intf;

import com.zx.coupon.customer.dao.entity.Coupon;
import com.zx.coupon.template.api.bean.RequestCoupon;

/**
 * 用户对接服务
 * @author zhangxin
 * @date 2022/11/10 16:35
 */
public interface CouponCustomerService {
    // 领券接口
    Coupon requestCoupon(RequestCoupon request);

}
