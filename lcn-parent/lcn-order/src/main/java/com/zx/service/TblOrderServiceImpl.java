package com.zx.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.zx.mapper.TblOrderMapper;
import com.zx.service.TblOrderService;

/**
 * @author zhangxin
 * @date 2022-01-15 20:53
 */

@Service
public class TblOrderServiceImpl implements TblOrderService {


    @Resource
    private TblOrderMapper tblOrderMapper;


    public  void  test(){


    }

}
