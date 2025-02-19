package com.es.cloud.generate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;

@MapperScan(basePackages = "com.es.cloud.generate.mapper")
@SpringBootApplication(exclude = JdbcRepositoriesAutoConfiguration.class)
public class EsGendbApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsGendbApplication.class, args);
    }

}
