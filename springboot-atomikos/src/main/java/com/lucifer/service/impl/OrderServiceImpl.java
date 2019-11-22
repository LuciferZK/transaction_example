package com.lucifer.service.impl;


import com.lucifer.log.mapper.LogMapper;
import com.lucifer.order.mapper.OrderMapper;
import com.lucifer.pojo.LogInfo;
import com.lucifer.pojo.OrderInfo;
import com.lucifer.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Random;

/**
 * @author Lucifer
 */
@Slf4j
@Service
@Transactional(rollbackOn = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    LogMapper logMapper;


    @Override
    public void addOrder(OrderInfo orderInfo) {
        int insert = orderMapper.insertOrderInfo(orderInfo);
        log.info("order库新增sql执行条数:{}",insert);

        //测试1 异常回滚
        //int i=1/0;

        LogInfo logInfo=new LogInfo();
        logInfo.setId((new Random().nextInt()));
        logInfo.setCreateTime(new Date());
        logInfo.setContent(orderInfo.toString());
        int insert1 = logMapper.insertLogInfo(logInfo);
        log.info("logs库新增sql执行条数:{}",insert1);

        //测试2 异常回滚
        int i=1/0;
    }




}
