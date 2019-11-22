package com.lucifer;

import com.lucifer.pojo.OrderInfo;
import com.lucifer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class SpringbootAtomikosApplicationTests {

    @Resource
    OrderService orderService;

    @Test
     void test1() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId((new Random().nextInt()));
        orderInfo.setAddress("上海");
        orderInfo.setCreateTime(new Date());
        orderInfo.setUserId("路西法");
        orderInfo.setMoney(new Random().nextDouble());
        orderService.addOrder(orderInfo);
    }

}