package com.seasonsfood.mall.web.all.admin.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ron
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket clientApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("client")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .paths(Predicates.or(PathSelectors.regex("/*")))
                .build()
                .apiInfo(clientApiInfo());
        ;
        return docket;
    }

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                //过滤的接口
                .paths(Predicates.or(PathSelectors.regex("/.*")))
                .build()
                .apiInfo(adminApiInfo());
    }

    private ApiInfo clientApiInfo() {
        //大标题
        ApiInfo apiInfo = new ApiInfo("client相关接口",
                //小标题
                "client相关接口，主要用于测试.",
                //版本
                "1.0",
                "",
                //作者
                "黄仁义",
                //链接显示文字
                "前端接口",
                //网站链接
                ""
        );

        return apiInfo;
    }

    private ApiInfo adminApiInfo() {
        //大标题
        ApiInfo apiInfo = new ApiInfo("admin相关接口",
                //小标题
                "Demo相关接口，获取个数，获取列表，注意：",
                //版本
                "1.0",
                "",
                //作者
                "黄仁义",
                //链接显示文字
                "后端管理接口",
                //网站链接
                ""
        );

        return apiInfo;
    }
}

