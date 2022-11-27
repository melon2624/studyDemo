package com.zx.coupon.customer.dao.servie.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.coupon.customer.dao.entity.Coupon;
import com.zx.coupon.customer.dao.mapper.CouponMapper;
import com.zx.coupon.customer.dao.servie.CouponService;
import org.springframework.stereotype.Service;


/**
 * @author zhangxin
 * @date 2022/11/14 9:58
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon>
    implements CouponService {

    @Override
    public long countByUserIdAndTemplateId(Long userId, Long templateId) {
        return 5;
    }
}




