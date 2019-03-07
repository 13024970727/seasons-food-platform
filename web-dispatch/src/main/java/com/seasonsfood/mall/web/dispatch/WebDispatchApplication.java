package com.seasonsfood.mall.web.dispatch;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@DubboComponentScan(basePackages = "com.seasonsfood.mall.web.dispatch")
@EnableDubboConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class WebDispatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDispatchApplication.class, args);
    }

}

