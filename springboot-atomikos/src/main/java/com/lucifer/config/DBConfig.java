package com.lucifer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 数据源1配置类
 * 用于读取配置文件自定义配置
 *
 * @author Lucifer
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid.master")
public class DBConfig {

    private String url;
    private String username;
    private String password;

}
