package com.lucifer.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Lucifer
 */
@Configuration
@MapperScan(basePackages = "com.lucifer.order.mapper", sqlSessionFactoryRef = "firstSqlSessionFactory")
public class MybatisDatasourceConfig {

    @Primary
    @Bean(name = "firstDataSource")
    public DataSource firstDataSource(DBConfig dbConfig) throws SQLException {
        //获取mysqlXaDataSource
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        //数据源配置
        mysqlXaDataSource.setUrl(dbConfig.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dbConfig.getPassword());
        mysqlXaDataSource.setUser(dbConfig.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        //将mysql数据源交由Atomikos统一管理
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("firstDataSource");
        return xaDataSource;
    }

    /**
     * 设置SqlSessionFactory，每一个数据源一个SqlSessionFactoryBean
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "firstSqlSessionFactory")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/order/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "firstSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
