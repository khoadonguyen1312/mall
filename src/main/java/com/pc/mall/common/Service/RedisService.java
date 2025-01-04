package com.pc.mall.common.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisService {

    // Normal data type operations
    // Các thao tác với kiểu dữ liệu bình thường

    // Set a value in Redis
    // Đặt giá trị trong Redis
    void set(String key, Object value);

    // Set a value with an expiration time
    // Đặt giá trị với thời gian hết hạn
    void set(String key, Object value, long time);

    // Get a value from Redis
    // Lấy giá trị từ Redis
    Object get(String key);

    // Delete a key from Redis
    // Xóa một key khỏi Redis
    boolean del(String key);

    // Delete multiple keys from Redis
    // Xóa nhiều key khỏi Redis
    Long del(List<String> keys);

    // Set the expiration time of a key in Redis
    // Thiết lập thời gian hết hạn của một key trong Redis
    Boolean expire(String key, long time);

    // Get the expiration time of a key
    // Lấy thời gian hết hạn của một key
    long getExpire(String key);

    // Check if a key exists in Redis
    // Kiểm tra xem một key có tồn tại trong Redis không
    boolean hasKey(String key);

    // Increment the value of a key by delta
    // Tăng giá trị của một key lên theo delta
    long incr(String key, long delta);

    // Decrement the value of a key by delta
    // Giảm giá trị của một key đi theo delta
    long decr(String key, long delta);

    //hash data type
    //kiểu dữ liệu hash

    void hset(String key,String  haskey, Object value);
    Boolean hset(String key , String haskey, Object value, long time);
    Boolean hSetAll(String key, Map<Object,Object> map, long time);
    void hSetAll(String key, Map<Object,Object> map);
    Object hget(String key, String haskey);
    Map<Object, Object> hgetall(String key);
    Long hdel(String key, Object ... value);
    boolean hhaskey(String key,String haskey);
    Long hincr(String key, String haskey , long delta);
    Long hdecr(String key, String haskey, long delta);
    //set data type
    // kiểu dữ liệu set

    Set<Object> sMember(String key);
    Long sAdd(String key, Object ...value);
    Boolean sIsMember(String key, Object value);
    long sSize(String key);
    Boolean sAdd(String key, long time, Object ...value);
    long sRemove(String key,Object ... values);

    //list data type

    //kiểu dữ liệu list

    void lRange(String key,long start,long end);
    Long lSize(String key);
    Object lIndex(String key, long index);
    Long lPush(String key, Object value);
    Boolean lPush(String key , Object value, long time);
    Long lPushAll(String key, Object... value);
    Boolean lPushAll(String key, long time, Object... value);
    Long lRemove(String key, long count, Object  value);


}
