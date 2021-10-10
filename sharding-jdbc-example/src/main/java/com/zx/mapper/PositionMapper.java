package com.zx.mapper;

import com.zx.entity.Position;

/**
 * @author zhangxin
 * @date 2021/10/11 1:26
 */
public interface PositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}