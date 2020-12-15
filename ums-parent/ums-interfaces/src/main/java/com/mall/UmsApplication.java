package com.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wcy
 */
@MapperScan("com.mall.ums.infrastructure.mapper")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsApplication.class, args);
    }
}
