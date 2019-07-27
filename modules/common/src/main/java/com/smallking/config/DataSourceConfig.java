package com.smallking.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @program: learn
 * @description: JPA多数据源配置
 * @author: smallking
 * @data: 2019-07-27 19:58
 **/
@Configuration
public class DataSourceConfig {

    @Primary
    @Bean("postgreSqlDataSource")
    @ConfigurationProperties("spring.datasource.druid.postgresql")
    public DataSource postgreSqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("mySqlDataSource")
    @ConfigurationProperties("spring.datasource.druid.mysql")
    public DataSource mySqlDataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
