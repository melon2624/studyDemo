package com.zx.coupon.template.service;

import com.zx.coupon.dao.entity.CouponTemplate;
import com.zx.coupon.dao.mapper.CouponTemplateMapper;
import com.zx.coupon.template.api.bean.CouponTemplateInfo;
import com.zx.coupon.template.converter.CouponTemplateConverter;
import com.zx.coupon.template.service.intf.CouponTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 优惠券模板类相关操作
 *
 * @author zhangxin
 * @date 2022/11/14 18:35
 */
@Slf4j
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    CouponTemplateMapper couponTemplateMapper;

    /**
     * 通过ID查询优惠券模板
     */
    @Override
    public CouponTemplateInfo loadTemplateInfo(Long templateId) {
        Optional<CouponTemplate> template = Optional.ofNullable(couponTemplateMapper.selectById(templateId));

        return template.map(CouponTemplateConverter::convertToTemplateInfo).orElse(null);
    }
}
