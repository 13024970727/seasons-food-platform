package com.seasonsfood.mall.web.shop.admin;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @author ron
 */
@DubboComponentScan(basePackages = "com.seasonsfood.mall.web.shop.admin")
@EnableDubboConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class WebShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebShopAdminApplication.class, args);
    }
}
