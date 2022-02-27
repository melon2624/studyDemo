package com.zx.two.service;

import com.zx.two.dao.TblTwoDao;
import com.zx.two.entity.TblTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


/**
 * @author yueyi2019
 */
@Service
public class RmTwoService {
	
	@Autowired
	TblTwoDao mapper;
	
	public String rm2() {
		TblTwo o = new TblTwo();
		o.setId(2);
		o.setName("rm2");
		mapper.insertSelective(o);
		
		return "";
	}
	
	public String updateRm2() {
		TblTwo o = mapper.selectByPrimaryKey(2);
		o.setName(o.getName()+new Random().nextInt(2));
		mapper.updateByPrimaryKeySelective(o);
		return "";
	}
}