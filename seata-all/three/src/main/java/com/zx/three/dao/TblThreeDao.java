package com.zx.three.dao;

import com.zx.three.entity.TblThree;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblThreeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TblThree record);

    int insertSelective(TblThree record);

    TblThree selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblThree record);

    int updateByPrimaryKey(TblThree record);
}