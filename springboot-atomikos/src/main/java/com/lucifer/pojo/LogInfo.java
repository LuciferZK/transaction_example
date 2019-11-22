package com.lucifer.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author Lucifer
 */
@Data
public class LogInfo {

    private Integer id;

    private Date createTime;

    private String content;
}
