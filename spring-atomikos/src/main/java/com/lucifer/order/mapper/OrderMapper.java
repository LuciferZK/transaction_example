package com.lucifer.order.mapper;

import com.lucifer.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lucifer
 */
public interface OrderMapper {

    /**
     * 新增
     * @param orderInfo
     * @return
     */
    int insertOrderInfo(OrderInfo orderInfo);

    /**
     * 批量新增
     * @param orderInfos
     * @return
     */
    int insertBatchOrder(@Param("orderInfos") List<OrderInfo> orderInfos);
}
