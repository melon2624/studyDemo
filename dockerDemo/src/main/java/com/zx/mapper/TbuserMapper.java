package com.zx.mapper;

import com.zx.entity.Tbuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}




