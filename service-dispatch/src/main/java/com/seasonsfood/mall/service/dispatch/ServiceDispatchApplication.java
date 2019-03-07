package com.seasonsfood.mall.service.dispatch;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDubboConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.seasonsfood.mall")
@MapperScan(basePackages = "com.seasonsfood.mall.service.dispatch.mapper")
@SpringBootApplication
public class ServiceDispatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDispatchApplication.class, args);
    }

}
