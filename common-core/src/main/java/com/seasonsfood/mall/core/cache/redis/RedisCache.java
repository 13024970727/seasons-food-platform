package com.seasonsfood.mall.core.cache.redis;

import com.seasonsfood.mall.util.util.RedisUtils;

/**
 * @author ron
 */
public class RedisCache {

    RedisUtils<Object> redisUtils;

    public RedisUtils<Object> getRedisUtils() {
        return redisUtils;
    }

    public void setRedisUtils(RedisUtils<Object> redisUtils) {
        this.redisUtils = redisUtils;
    }

    /**
     * 从Redis缓存获取数据
     * @param redisKey
     * @return
     */
    public Object getDataFromRedis(String redisKey){
        return redisUtils.getValue(redisKey);
    }

    /**
     * 保存数据到Redis
     * @param redisKey
     */
    public Boolean saveDataToRedis(String redisKey,Object obj){

        return redisUtils.cacheValue(redisKey,obj);
    }

    public Boolean cleanData(String redisKey){

        return redisUtils.remove(redisKey);

    }


}
