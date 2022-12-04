package com.zx.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.entity.Tbuser;
import com.zx.service.TbuserService;
import com.zx.mapper.TbuserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xkdtm
 * @description 针对表【tbuser】的数据库操作Service实现
 * @createDate 2022-05-05 10:23:24
 */
@Service
public class TbuserServiceImpl extends ServiceImpl<TbuserMapper, Tbuser>
        implements TbuserService {

    @Autowired
    TbuserMapper tbuserMapper;

    public List<Tbuser> list() {

        LambdaQueryWrapper<Tbuser> tbuserLambdaQueryWrapper = new LambdaQueryWrapper<>();

        tbuserLambdaQueryWrapper.eq(Tbuser::getUserid,1);

        return  tbuserMapper.selectList(tbuserLambdaQueryWrapper);

    }


    @Override
    public List<Tbuser> add() {
        return null;
    }
}




