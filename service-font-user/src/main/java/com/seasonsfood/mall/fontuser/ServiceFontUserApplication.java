package com.seasonsfood.mall.fontuser;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ron
 */
@EnableDubboConfiguration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.seasonsfood.mall"})
@MapperScan(basePackages = "com.seasonsfood.mall.fontuser.mapper")
@SpringBootApplication
public class ServiceFontUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFontUserApplication.class, args);
    }
}
