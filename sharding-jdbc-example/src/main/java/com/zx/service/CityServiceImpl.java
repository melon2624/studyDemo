package com.zx.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.mapper.CityMapper;
import com.zx.entity.City;
import com.zx.service.CityService;

/**
 * @author zhangxin
 * @date 2021/10/13 0:04
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

}
