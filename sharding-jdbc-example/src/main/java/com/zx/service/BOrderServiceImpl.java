package com.zx.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.entity.BOrder;
import com.zx.mapper.BOrderMapper;
import com.zx.service.BOrderService;
/**
 * @author  zhangxin
 * @date  2021/10/13 0:43
 */
@Service
public class BOrderServiceImpl extends ServiceImpl<BOrderMapper, BOrder> implements BOrderService{

}
