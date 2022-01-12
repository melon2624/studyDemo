package com.zx.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TblOrderEventMapper;

/**
 * @author  zhangxin
 * @date  2022-01-13 2:01
 */

@Service
public class TblOrderEventServiceImpl implements TblOrderEventService{

    @Resource
    private TblOrderEventMapper tblOrderEventMapper;

}
