package com.lucifer.test;

import com.lucifer.pojo.OrderInfo;
import com.lucifer.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class test {

    @Resource
    OrderService orderService;

    @Test
    public void test1() {
        //等同@ContextConfiguration("classpath:spring.xml")
        //ClassPathXmlApplicationContext cat = new ClassPathXmlApplicationContext("spring.xml");
        //等同 @Resource  OrderService orderService;
       // OrderService orderService = cat.getBean(OrderService.class);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId((new Random().nextInt()));
        orderInfo.setAddress("上海");
        orderInfo.setCreateTime(new Date());
        orderInfo.setUserId("路西法");
        orderInfo.setMoney(new Random().nextDouble());
        orderService.addOrder(orderInfo);
    }

    @Test
    public void test2() {
        List<OrderInfo> orderInfoList=new ArrayList<OrderInfo>();
        for(int i=0;i<10;i++){
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId((new Random().nextInt()));
            orderInfo.setAddress("上海");
            orderInfo.setCreateTime(new Date());
            orderInfo.setUserId("路西法");
            orderInfo.setMoney(new Random().nextDouble());
            orderInfoList.add(orderInfo);
        }
        orderService.addBatchOrder(orderInfoList);
    }



}
