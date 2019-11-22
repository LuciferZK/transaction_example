package com.lucifer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 数据源2配置类
 * 用于读取配置文件自定义配置
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
public class DBConfig2 {

    private String url;
    private String username;
    private String password;

}
