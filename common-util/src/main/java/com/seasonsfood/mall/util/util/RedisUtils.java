package com.seasonsfood.mall.util.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * @author ron
 * @param <V>
 */
public class RedisUtils<V> {
    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 主数据源
     */
    private RedisTemplate<String, V> redisTemplate;



    /**
     * 缓存value操作
     *
     * @param key
     * @param value
     * @param time
     *
     * @return
     */
    public boolean cacheValue(String key, V value, long time) {
        try {
            ValueOperations<String, V> valueOps = redisTemplate.opsForValue();
            valueOps.set(key, value);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存value操作
     *
     * @param key
     * @param value
     *
     * @return
     */
    public boolean cacheValue(String key, V value) {
        return cacheValue(key, value, -1);
    }

    /**
     * 是否存在该主键
     *
     * @param key
     *
     * @return
     */
    public boolean containsKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Throwable t) {
            logger.error("判断缓存存在失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }


    /**
     * 获取缓存
     *
     * @param key
     *         主键
     *
     * @return
     */
    public V getValue(String key) {
        try {
            ValueOperations<String, V> valueOps = redisTemplate.opsForValue();
            return valueOps.get(key);
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return null;
    }


    /**
     * 移除缓存
     *
     * @param key
     *
     * @return
     */
    public boolean removeValue(String key) {
        return remove(key);
    }

    public boolean removeSet(String key) {
        return remove(key);
    }

    public boolean removeList(String key) {
        return remove(key);
    }

    /**
     * 移除缓存
     *
     * @param key
     *
     * @return
     */
    public boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    /**
     * 缓存set操作
     *
     * @param key
     * @param value
     * @param time
     *
     * @return
     */
    public boolean cacheSet(String key, V value, long time) {
        try {
            SetOperations<String, V> valueOps = redisTemplate.opsForSet();
            valueOps.add(key, value);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存set
     *
     * @param key
     * @param value
     *
     * @return
     */
    public boolean cacheSet(String key, V value) {
        return cacheSet(key, value, -1);
    }

    /**
     * 缓存set
     *
     * @param key
     * @param value
     * @param time
     *
     * @return
     */
    public boolean cacheSet(String key, Set<V> value, long time) {
        try {
            SetOperations<String, V> setOps = redisTemplate.opsForSet();
//            setOps.add(key, value.toArray(new Object[value.size()]));
            setOps.add(key, (V[]) value.toArray());
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存set
     *
     * @param key
     * @param value
     *
     * @return
     */
    public boolean cacheSet(String key, Set<V> value) {
        return cacheSet(key, value, -1);
    }

    /**
     * 获取缓存set数据
     *
     * @param key
     *
     * @return
     */
    public Set<V> getSet(String key) {
        try {
            SetOperations<String, V> setOps = redisTemplate.opsForSet();
            return setOps.members(key);
        } catch (Throwable t) {
            logger.error("获取set缓存失败key[" + key + ", error[" + t + "]");
        }
        return null;
    }


    /**
     * list缓存
     *
     * @param key
     * @param value
     * @param time
     *
     * @return
     */
    public boolean cacheList(String key, V value, long time) {
        try {
            ListOperations<String, V> listOps = redisTemplate.opsForList();
            listOps.rightPush(key, value);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存list
     *
     * @param key
     * @param value
     *
     * @return
     */
    public boolean cacheList(String key, V value) {
        return cacheList(key, value, -1);
    }


    /**
     * 在list队列尾部加入一个对象
     * @param key
     * @param value
     * @return
     */
    public boolean push(String key,V value){
        return cacheList(key, value, -1);
    }

    /**
     * 头部弹出一个对象并且删除
     * @param key
     * @return
     */
    public V pop(String key) {
        try {
            ListOperations<String, V> listOps = redisTemplate.opsForList();
            return listOps.leftPop(key);
        } catch (Throwable t) {
            logger.error("移除list缓存失败key[" + key + ", error[" + t + "]");
        }
        return null;
    }


    /**
     * 缓存list
     *
     * @param key
     * @param value
     * @param time
     *
     * @return
     */
    public boolean cacheList(String key, List<V> value, long time) {
        try {
            ListOperations<String, V> listOps = redisTemplate.opsForList();
            long l = listOps.rightPushAll(key, value);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存list
     *
     * @param key
     * @param value
     *
     * @return
     */
    public boolean cacheList(String key, List<V> value) {
        return cacheList(key, value, -1);
    }

    /**
     * 获取list缓存
     *
     * @param key
     * @param start
     * @param end
     *
     * @return
     */
    public List<V> getList(String key, long start, long end) {
        try {
            ListOperations<String, V> listOps = redisTemplate.opsForList();
            return listOps.range(key, start, end);
        } catch (Throwable t) {
            logger.error("获取list缓存失败key[" + key + ", error[" + t + "]");
        }
        return null;
    }


    /**
     * 获取总条数, 可用于分页
     *
     * @param key
     *
     * @return
     */
    public long getListSize(String key) {
        try {
            ListOperations<String, V> listOps = redisTemplate.opsForList();
            return listOps.size(key);
        } catch (Throwable t) {
            logger.error("获取list长度失败key[" + key + "], error[" + t + "]");
        }
        return 0;
    }


    /**
     * 获取总条数, 可用于分页
     *
     * @param listOps
     * @param key
     *
     * @return
     */
    public long getListSize(ListOperations<String, V> listOps, String key) {
        try {
            return listOps.size(key);
        } catch (Throwable t) {
            logger.error("获取list长度失败key[" + key + "], error[" + t + "]");
        }
        return 0;
    }


    /**
     * 移除list缓存
     *
     * @param key
     *
     * @return
     */
    public boolean removeOneOfList(String key) {
        try {
            ListOperations<String, V> listOps = redisTemplate.opsForList();
            listOps.rightPop(key);
            return true;
        } catch (Throwable t) {
            logger.error("移除list缓存失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    /**
     * 根据Key前缀获取
     *
     * @param prefix
     *         Key前缀
     *
     * @return
     */
    public List<V> getListByPrefix(String prefix) {
        List<V> result = new ArrayList<>();
        ValueOperations<String, V> valueOperations = redisTemplate.opsForValue();
        Set<String> keys = getKeysByPrefix(prefix);
        for (String key : keys) {
            result.add(this.getValue(key));
        }
        return result;
    }


    /**
     * 获取以某个前缀开头的所有Key
     *
     * @param prefix
     *         Key前缀
     *
     * @return 以某个前缀开头的所有Key集合
     */
    public Set<String> getKeysByPrefix(String prefix) {
        return redisTemplate.keys(prefix + "*");
    }


    /**
     * 获取以某个前缀开头的key数量
     *
     * @param prefix
     *         Key前缀
     *
     * @return 以某个前缀开头的key数量
     */
    public Integer getCountByPrefix(String prefix) {
        return getKeysByPrefix(prefix).size();
    }


    public RedisTemplate<String, V> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


}
