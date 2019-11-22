package com.lucifer.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Lucifer
 */
@Data
public class OrderInfo {

    private Integer id;

    private Double money;

    private String userId;

    private String address;

    private Date createTime;

}
