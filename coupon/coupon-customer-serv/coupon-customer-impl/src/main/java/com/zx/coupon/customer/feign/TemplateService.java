package com.zx.coupon.customer.feign;

import com.zx.coupon.customer.feign.fallback.TemplateServiceFallback;
import com.zx.coupon.template.api.bean.CouponTemplateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022/11/26 8:47
 */
@FeignClient(value = "coupon-template-serv", path = "/template",
        // 通过fallback指定降级逻辑
        fallback = TemplateServiceFallback.class)
public interface TemplateService {

    //读取优惠券
    @GetMapping("getTemplate")
    CouponTemplateInfo getTemplate(@RequestParam("id") Long id);

    // 批量获取
    @GetMapping("/getBatch")
    Map<Long, CouponTemplateInfo> getTemplateInBatch(@RequestParam("ids") Collection<Long> ids);

}
