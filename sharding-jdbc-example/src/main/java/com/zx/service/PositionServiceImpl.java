package com.zx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.entity.Position;
import com.zx.entity.PositionDetail;
import com.zx.mapper.PositionDetailMapper;
import com.zx.mapper.PositionMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author zhangxin
 * @date 2021/10/11 1:20
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements  PositionService {


}


