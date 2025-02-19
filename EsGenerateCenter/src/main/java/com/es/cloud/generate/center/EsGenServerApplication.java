package com.es.cloud.generate.center;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {JdbcRepositoriesAutoConfiguration.class,
        DruidDataSourceAutoConfigure.class, DataSourceAutoConfiguration.class}
//        ,scanBasePackages = "com.es.cloud.generate"
)
public class EsGenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsGenServerApplication.class, args);
    }

}
