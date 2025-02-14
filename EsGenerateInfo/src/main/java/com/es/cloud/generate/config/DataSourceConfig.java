package com.es.cloud.generate.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.es.cloud.generate.common.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    //数据源1
    @Bean(name = "readDb")
    @ConfigurationProperties(prefix = "spring.datasource.readdb")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    //数据源2
    @Bean(name = "writeDb")
    @ConfigurationProperties(prefix = "spring.datasource.writedb")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }


    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource2());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<Object, Object>();
        dsMap.put("readDb", dataSource1());
        dsMap.put("writeDb", dataSource2());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}
