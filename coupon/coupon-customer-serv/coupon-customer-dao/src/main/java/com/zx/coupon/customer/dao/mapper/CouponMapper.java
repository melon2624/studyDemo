package com.zx.coupon.customer.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.coupon.customer.dao.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;

/**
 * * @description 针对表【coupon(领到手的优惠券)】的数据库操作Mapper
 * @author zhangxin
 * @date 2022/11/14 9:58
 */
@Mapper
public interface CouponMapper extends BaseMapper<Coupon> {

}




