package com.zx.service;

import com.zx.entity.TblOrderEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.zx.mapper.TblOrderEventMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author zhangxin
 * @date 2022-01-13 2:01
 */

@Service
public class TblOrderEventServiceImpl implements TblOrderEventService {

    @Resource
    private TblOrderEventMapper tblOrderEventMapper;

    public List<TblOrderEvent> selectOrderByOrderType() {

        Example example = new Example(TblOrderEvent.class);
        example.createCriteria().andEqualTo("orderType", 1);

        return null;

    }

    public  void updateEvent(int orderType){

    }


}
