package com.zx.mapper;

import com.zx.entity.CompareVo;
import com.zx.entity.Tbuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xkdtm
* @description 针对表【tbuser】的数据库操作Mapper
* @createDate 2022-05-05 10:23:24
* @Entity generator.domain.Tbuser
*/
@Mapper
public interface TbuserMapper extends BaseMapper<Tbuser> {

    public Integer test(List<Integer> list);

    void add(@Param("compareVo") CompareVo compareVo);
    void add2(@Param("compareVo") CompareVo compareVo);

    List<CompareVo> select1();
    List<CompareVo> select2();

    void adAnser(String message);
}




