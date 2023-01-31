package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Coupon;
import generator.service.CouponService;

import org.springframework.stereotype.Service;

/**
* @author xkdtm
* @description 针对表【coupon(领到手的优惠券)】的数据库操作Service实现
* @createDate 2022-11-14 10:53:15
*/
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon>
    implements CouponService{

}




