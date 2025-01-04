package com.pc.mall.common.Service.impl;

import com.pc.mall.common.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Long del(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    @Override
    public Boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    @Override
    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    @Override
    public void hset(String key, String haskey, Object value) {
        redisTemplate.opsForHash().put(key, haskey, value);
    }

    @Override
    public Boolean hset(String key, String haskey, Object value, long time) {
        redisTemplate.opsForHash().put(key, haskey, value);
        return expire(key, time);
    }

    @Override
    public Boolean hSetAll(String key, Map<Object, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        return expire(key, time);

    }

    @Override
    public void hSetAll(String key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public Object hget(String key, String haskey) {
        return redisTemplate.opsForHash().get(key, haskey);
    }

    @Override
    public Map<Object, Object> hgetall(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    @Override
    public Long hdel(String key, Object... value) {
        return redisTemplate.opsForHash().delete(key, value);
    }

    @Override
    public boolean hhaskey(String key, String haskey) {
        return redisTemplate.opsForHash().hasKey(key, haskey);
    }

    @Override
    public Long hincr(String key, String haskey, long delta) {
        return redisTemplate.opsForHash().increment(key, haskey, delta);
    }

    @Override
    public Long hdecr(String key, String haskey, long delta) {
        return redisTemplate.opsForHash().increment(key, haskey, -delta);
    }

    @Override
    public Set<Object> sMember(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public Long sAdd(String key, Object... value) {
            return redisTemplate.opsForSet().add(key,value);
    }

    @Override
    public Boolean sIsMember(String key, Object value) {
            return redisTemplate.opsForSet().isMember(key,value);
    }

    @Override
    public long sSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    @Override
    public Boolean sAdd(String key, long time, Object... value) {
        redisTemplate.opsForSet().add(key,value);
        return expire(key,time);
    }

    @Override
    public long sRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key,values);
    }

    @Override
    public void lRange(String key, long start, long end) {
         redisTemplate.opsForList().range(key,start,end);
    }

    @Override
    public Long lSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Object lIndex(String key, long index) {
        return redisTemplate.opsForList().index(key,index);
    }

    @Override
    public Long lPush(String key, Object value) {
       return redisTemplate.opsForList().rightPush(key,value);
    }

    @Override
    public Boolean lPush(String key, Object value, long time) {
         redisTemplate.opsForList().rightPush(key,value);
         return expire(key,time);

    }

    @Override
    public Long lPushAll(String key, Object... value) {
        return redisTemplate.opsForList().rightPushAll(key,value);
    }

    @Override
    public Boolean lPushAll(String key, long time, Object... value) {
         redisTemplate.opsForList().rightPushAll(key,value);
         return expire(key,time);

    }

    @Override
    public Long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key,count,value);
    }
}
