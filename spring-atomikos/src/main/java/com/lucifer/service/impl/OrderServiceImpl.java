package com.lucifer.service.impl;


import com.lucifer.log.mapper.LogMapper;
import com.lucifer.order.mapper.OrderMapper;
import com.lucifer.pojo.LogInfo;
import com.lucifer.service.OrderService;
import org.springframework.stereotype.Service;
import com.lucifer.pojo.OrderInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Lucifer
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    LogMapper logMapper;

    public void addOrder(OrderInfo orderInfo) {

        //新增（order库）
        int i=orderMapper.insertOrderInfo(orderInfo);
        System.out.println("order库，执行sql条数:"+i);

        //测试1
        int k=1/0;

        //新增 （logs库）
        LogInfo logInfo = new LogInfo();
        logInfo.setId(new Random().nextInt());
        logInfo.setCreateTime(new Date());
        logInfo.setContent(orderInfo.toString());
        int i1 = logMapper.insertLogInfo(logInfo);
        System.out.println("logs库，执行sql条数:"+i1);
        //测试2
       // int k=1/0;
    }

    public void addBatchOrder(List<OrderInfo> orderInfos) {
        int i=orderMapper.insertBatchOrder(orderInfos);
        System.out.println("order库，执行sql条数:"+i);

        //测试1
       // int k=1/0;

        //新增 （logs库）
        List<LogInfo> logInfoList=new ArrayList<LogInfo>();
        for(int j=0;j<orderInfos.size();j++){
            LogInfo logInfo = new LogInfo();
            logInfo.setId(new Random().nextInt());
            logInfo.setCreateTime(new Date());
            logInfo.setContent(orderInfos.get(j).toString());
            logInfoList.add(logInfo);
        }
        int i1 =logMapper.insertBatchLogs(logInfoList);
        System.out.println("logs库，执行sql条数:"+i1);
        //测试2
        int k=1/0;
    }
}
