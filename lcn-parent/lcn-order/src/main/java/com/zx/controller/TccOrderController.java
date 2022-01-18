package com.zx.controller;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.zx.entity.TblOrder;
import com.zx.mapper.TblOrderMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxin
 * @date 2022-01-16 17:11
 */
@RestController
public class TccOrderController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TblOrderMapper tblOrderMapper;

    private static Map<String, Integer> maps = new HashMap<>();


    @TccTransaction
    @PostMapping("/add-order-tcc")
    @Transactional(rollbackFor = Exception.class)
    public String add(@RequestBody TblOrder bean) {


        JSONObject date = new JSONObject();
        date.put("payName", bean.getOrderName() + "pay");

        restTemplate.postForEntity("http://localhost:1002/add-pay-tcc", date, String.class);

        tblOrderMapper.insert(bean);
        Integer id = bean.getId();
        maps.put("a", id);
        //int i = 1/0;
        return "新增订单成功";
    }


    public String confirmAdd(TblOrder bean) {
        System.out.println("order confirm ");
        return "新增订单成功";
    }

    public String cancelAdd(TblOrder bean) {
        Integer a = maps.get("a");
        System.out.println(a);
        tblOrderMapper.deleteByPrimaryKey(a);
        System.out.println("order cancel ");
        return "新增订单成功";
    }


}
