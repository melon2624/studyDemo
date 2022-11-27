package com.zx.coupon.customer.constant.controller;

import com.zx.coupon.customer.dao.entity.Coupon;
import com.zx.coupon.customer.service.intf.CouponCustomerService;
import com.zx.coupon.template.api.bean.RequestCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhangxin
 * @date 2022/11/14 11:26
 */
@Slf4j
@RestController
@RequestMapping("coupon-customer")
public class CouponCustomerController {

    @Autowired
    private CouponCustomerService customerService;

    @PostMapping("requestCoupon")
    public Coupon requestCoupon(@Valid @RequestBody RequestCoupon request) {
      //  return customerService.requestCoupon(request);
        return  customerService.requestCouponByFeign(request);
    }

}
