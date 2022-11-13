package com.zx.coupon.customer.service;

import com.zx.coupon.customer.dao.entity.Coupon;
import com.zx.coupon.customer.service.intf.CouponCustomerService;
import com.zx.coupon.template.api.bean.CouponTemplateInfo;
import com.zx.coupon.template.api.bean.RequestCoupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


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
    private WebClient.Builder webClientBuilder;

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
        Long expTime = templateInfo.getRule().getDeadline();
     //   if (expTime!=null&&now>=expTime|| BooleanUtis.is)
        return null;
    }
}
