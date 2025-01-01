package com.pc.mall.common.Service.impl;

import com.pc.mall.common.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class RedisServiceImpl implements RedisService {
@Autowired
private RedisTemplate<String,Object> redisTemplate ;
    @Override
    public void set(String key, Object value) {
            redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, Object value, long time) {

    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public boolean del(String key) {
        return false;
    }

    @Override
    public boolean del(List<String> keys) {
        return false;
    }

    @Override
    public long expire(String key, long time) {
        return 0;
    }

    @Override
    public long getExpire(String key) {
        return 0;
    }

    @Override
    public boolean hasKey(String key) {
        return false;
    }

    @Override
    public long incr(String key, long delta) {
        return 0;
    }

    @Override
    public long decr(String key, long delta) {
        return 0;
    }
}
