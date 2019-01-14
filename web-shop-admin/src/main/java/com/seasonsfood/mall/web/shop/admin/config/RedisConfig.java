package com.seasonsfood.mall.web.shop.admin.config;

import com.seasonsfood.mall.core.cache.aop.RedisAspect;
import com.seasonsfood.mall.core.cache.redis.RedisCache;
import com.seasonsfood.mall.util.util.RedisConfigHelper;
import com.seasonsfood.mall.util.util.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * @author ron
 */
@Configuration
public class RedisConfig {

    /**
     * redisTemplate 序列化使用的jdkSerializeable, 存储二进制字节码, 所以自定义序列化类
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return RedisConfigHelper.setRedisTemplate(redisConnectionFactory);
    }

    @Bean
    public RedisUtils redisUtils(RedisTemplate redisTemplate){
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setRedisTemplate(redisTemplate);
        return redisUtils;
    }

    @Bean
    public RedisCache redisCache(RedisUtils redisUtils){
        RedisCache redisCache = new RedisCache();
        redisCache.setRedisUtils(redisUtils);
        return redisCache;
    }

    @Bean
    public RedisAspect redisAspect(){
        RedisAspect redisAspect = new RedisAspect();
        return redisAspect;
    }

}
