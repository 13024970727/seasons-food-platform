package com.seasonsfood.mall.core.cache.annotation;


import java.lang.annotation.*;

/**
 * 元注解 用来标识查询数据库的方法
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache{

}



