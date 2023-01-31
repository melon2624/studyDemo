package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.CouponTemplate;
import generator.service.CouponTemplateService;
import generator.mapper.CouponTemplateMapper;
import org.springframework.stereotype.Service;

/**
* @author xkdtm
* @description 针对表【coupon_template(优惠券模板)】的数据库操作Service实现
* @createDate 2022-11-14 18:47:48
*/
@Service
public class CouponTemplateServiceImpl extends ServiceImpl<CouponTemplateMapper, CouponTemplate>
    implements CouponTemplateService{

}




