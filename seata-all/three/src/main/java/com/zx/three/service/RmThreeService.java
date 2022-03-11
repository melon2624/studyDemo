package com.zx.three.service;

import com.zx.three.dao.TblThreeDao;
import com.zx.three.entity.TblThree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yueyi2019
 */
@Service
public class RmThreeService {
	@Autowired
	TblThreeDao mapper;
	
	public String rm3() {
		
		TblThree o = new TblThree();
		o.setId(3);
		o.setName("rm3");
		mapper.insertSelective(o);
		
		return "";
	}
}