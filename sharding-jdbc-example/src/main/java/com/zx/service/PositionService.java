package com.zx.service;

import com.zx.entity.Position;

/**
 * @author zhangxin
 * @date 2021/10/11 1:20
 */
public interface PositionService {


    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

}

