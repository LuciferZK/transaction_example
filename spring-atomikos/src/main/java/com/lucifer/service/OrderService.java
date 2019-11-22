package com.lucifer.service;

import com.lucifer.pojo.OrderInfo;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderService {

    /**
     * 单个新增
     *
     * @param orderInfo
     */
    void addOrder(OrderInfo orderInfo);

    /**
     * 批量新增
     * @param orderInfos
     */
    void addBatchOrder(List<OrderInfo> orderInfos);

}
