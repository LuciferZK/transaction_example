package com.lucifer;

import com.lucifer.config.DBConfig;
import com.lucifer.config.DBConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Lucifer
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(value = { DBConfig.class, DBConfig2.class})
@MapperScan(value = {"com.lucifer.log.mapper","com.lucifer.order.mapper"})
public class SpringbootAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAtomikosApplication.class, args);
    }

}
