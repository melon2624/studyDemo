package com.zx;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.zx.entity.BOrder;
import com.zx.entity.City;
import com.zx.entity.Position;
import com.zx.entity.PositionDetail;
import com.zx.mapper.BOrderMapper;
import com.zx.mapper.CityMapper;
import com.zx.mapper.PositionDetailMapper;
import com.zx.mapper.PositionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class ShardingAppTests {

    @Resource
    private PositionMapper positionMapper;

    @Resource
    private PositionDetailMapper positionDetailMapper;

    @Resource
    private CityMapper cityMapper;

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

    @Test
    public  void testBroadTable(){
        City city=new City();
        city.setName("shenzhen");
        city.setProvince("guangdong");
        cityMapper.insert(city);
    }

    @Resource
    private BOrderMapper bOrderMapper;

    @Test
    public  void  testShardingBOrder(){

        Random random=new Random();
        int companyId=random.nextInt(10);

        BOrder bOrder=new BOrder();
        bOrder.setCompanyId(companyId);
        bOrder.setIsDel(false);
        bOrder.setPositionId((long) 1415458002);
        bOrder.setUserId(2222);
        bOrder.setPublishUserId(1111);
        bOrder.setResumeType(1);
        bOrder.setStatus("AUTO");
        bOrder.setCreateTime(new Date());
        bOrder.setOperateTime(new Date());
        bOrder.setWorkYear("2");
        bOrder.setName("lagou");
        bOrder.setPositionName("Java");
        bOrder.setResumeId(23233);

        bOrderMapper.insert(bOrder);

    }


}
