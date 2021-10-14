package com.zx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.entity.Position;
import com.zx.vo.PositionVo;

import java.util.List;

/**
 * @author : zhangxin
 * @date : 2021-10-12 15:45
 **/
public interface PositionMapper extends BaseMapper<Position> {


    public PositionVo getPositionDes(Long id);

}