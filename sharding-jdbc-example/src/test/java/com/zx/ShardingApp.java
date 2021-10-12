package com.zx;

import com.alibaba.fastjson.JSONObject;
import com.zx.entity.Position;
import com.zx.entity.PositionDetail;
import com.zx.mapper.PositionDetailMapper;
import com.zx.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ShardingAppTests {

    @Resource
    private PositionMapper positionMapper;

    @Resource
    private PositionDetailMapper positionDetailMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public  void testAdd(){

        for (int i=1;i<=20;i++){
            Position position=new Position();
           // position.setId(i);
            position.setName("zx"+i);
            position.setSalary("100");
            position.setCity("shenzhen");
            positionMapper.insert(position);

            PositionDetail positionDetail=new PositionDetail();
            positionDetail.setPid(position.getId());
            positionDetail.setDescription("message"+i);
            positionDetailMapper.insert(positionDetail);
        }
    }

    public  void  testfindById(){

    }

}
