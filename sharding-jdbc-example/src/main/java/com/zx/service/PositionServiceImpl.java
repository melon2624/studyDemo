package com.zx.service;

import com.zx.entity.Position;
import com.zx.mapper.PositionMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author zhangxin
 * @date 2021/10/11 1:20
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionMapper positionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return positionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Position record) {
        return positionMapper.insert(record);
    }

    @Override
    public int insertSelective(Position record) {
        return positionMapper.insertSelective(record);
    }

    @Override
    public Position selectByPrimaryKey(Long id) {
        return positionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Position record) {
        return positionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Position record) {
        return positionMapper.updateByPrimaryKey(record);
    }

}

