package com.zx.coupon.template.api.bean.rules;

import lombok.Data;

/**
 * @author zhangxin
 * @date 2022/11/11 11:05
 */
@Data
public class TemplateRule {

    /** 可以享受的折扣 */
    private Discount discount;

    // 每个人最多可以领券数量
    private Integer limitation;

    // 过期时间
    private Long deadline;


}
