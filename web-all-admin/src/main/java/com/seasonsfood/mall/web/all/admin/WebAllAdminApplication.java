package com.seasonsfood.mall.web.all.admin;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ron
 */
@DubboComponentScan(basePackages = "com.seasonsfood.mall.web.all.admin")
@EnableDubboConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class WebAllAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAllAdminApplication.class, args);
    }
}
