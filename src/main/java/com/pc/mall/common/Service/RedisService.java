package com.pc.mall.common.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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
    boolean del(List<String> keys);

    // Set the expiration time of a key in Redis
    // Thiết lập thời gian hết hạn của một key trong Redis
    long expire(String key, long time);

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
}
