package com.zx.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TblPayMapper;
import com.zx.service.TblPayService;

/**
 * @author  zhangxin
 * @date  2022-01-15 21:10
 */

@Service
public class TblPayServiceImpl implements TblPayService{

    @Resource
    private TblPayMapper tblPayMapper;

}
