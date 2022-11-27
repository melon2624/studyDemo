package com.zx.coupon.customer.service;

import com.zx.coupon.customer.dao.servie.CouponService;
import com.zx.coupon.customer.dao.entity.Coupon;
import com.zx.coupon.customer.feign.TemplateService;
import com.zx.coupon.customer.service.intf.CouponCustomerService;
import com.zx.coupon.template.api.bean.CouponTemplateInfo;
import com.zx.coupon.template.api.bean.RequestCoupon;
import com.zx.coupon.template.api.enums.CouponStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.apache.commons.lang3.BooleanUtils;


import java.util.Calendar;

import static com.zx.coupon.customer.constant.Constant.TRAFFIC_VERSION;

/**
 * @author zhangxin
 * @date 2022/11/12 11:02
 */
@Slf4j
@Service
public class CouponCustomerServiceImpl implements CouponCustomerService {


    @Autowired
    private CouponService couponService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private TemplateService templateService;


    @Override
    public Coupon requestCoupon(RequestCoupon request) {

        CouponTemplateInfo templateInfo = webClientBuilder.build()
                // 声明了这是一个GET方法
                .get()
                .uri("http://coupon-template-serv/template/getTemplate?id=" + request.getCouponTemplateId())
                .header(TRAFFIC_VERSION, request.getTrafficVersion())
                .retrieve()
                .bodyToMono(CouponTemplateInfo.class)
                .block();

        // 模板不存在则报错
        if (templateInfo == null) {
            log.error("invalid template id={}", request.getCouponTemplateId());
            throw new IllegalArgumentException("Invalid template id");
        }
        long now = Calendar.getInstance().getTimeInMillis();
       /* Long expTime = templateInfo.getRule().getDeadline();
        if (expTime != null && now >= expTime || BooleanUtils.isFalse(templateInfo.getAvailable())) {
            log.error("template is not available id={}", request.getCouponTemplateId());
            throw new IllegalArgumentException("template is unavailable");
        }*/
        // 用户领券数量超过上限
        Long count = couponService.countByUserIdAndTemplateId(request.getUserId(), request.getCouponTemplateId());

        if (count >= templateInfo.getRule().getLimitation()) {
            log.error("exceeds maximum number");
            throw new IllegalArgumentException("exceeds maximum number");
        }
        Coupon coupon = Coupon.builder()
                .templateId(request.getCouponTemplateId())
                .userId(request.getUserId())
                .shopId(templateInfo.getShopId())
                .status(CouponStatus.AVAILABLE)
                .templateInfo(templateInfo)
                .build();
        couponService.save(coupon);
        return coupon;
    }


    public Coupon requestCouponByFeign(RequestCoupon request) {
        log.info("request new coupon, body={}", request);

        CouponTemplateInfo templateInfo = templateService.getTemplate(request.getCouponTemplateId());

        // 模板不存在则报错
        if (templateInfo == null) {
            log.error("invalid template id={}", request.getCouponTemplateId());
            throw new IllegalArgumentException("Invalid template id");
        }

        // 模板不能过期
        long now = Calendar.getInstance().getTimeInMillis();
        Long expTime = templateInfo.getRule().getDeadline();
        if (expTime != null && now >= expTime || BooleanUtils.isFalse(templateInfo.getAvailable())) {
            log.error("template is not available id={}", request.getCouponTemplateId());
            throw new IllegalArgumentException("template is unavailable");
        }
        // 用户领券数量超过上限
        Long count = couponService.countByUserIdAndTemplateId(request.getUserId(), request.getCouponTemplateId());
        if (count >= templateInfo.getRule().getLimitation()) {
            log.error("exceeds maximum number");
            throw new IllegalArgumentException("exceeds maximum number");
        }
        Coupon coupon = Coupon.builder()
                .templateId(request.getCouponTemplateId())
                .userId(request.getUserId())
                .shopId(templateInfo.getShopId())
                .status(CouponStatus.AVAILABLE)
                .templateInfo(templateInfo)
                .build();
        couponService.save(coupon);

        return coupon;
    }

}
