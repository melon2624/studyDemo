package com.zx.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.mapper.PositionDetailMapper;
import com.zx.entity.PositionDetail;
import com.zx.service.PositionDetailService;

/**
 * @author : zhangxin
 * @date : 2021-10-12 15:44
 **/
@Service
public class PositionDetailServiceImpl extends ServiceImpl<PositionDetailMapper, PositionDetail> implements PositionDetailService {

}
