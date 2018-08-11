/**
 * Date:     2018/8/119:43
 * AUTHOR:   Administrator
 */
package com.zhou.springdata.config;

import com.zhou.springdata.SpringDataApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * 2018/8/11  9:43
 * created by zhoumb
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringDataApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplateInject() {
        Assert.notNull(redisTemplate, "RedisTemplate 未注入");
    }

    @Test
    public void testSetString() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("zhou", "zhuang");
        valueOperations.set("fhsdafhs", "fsdadfsad");

        System.out.println(valueOperations.get("zhou"));
    }

    @Test
    public void testTryLock() {
        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
        RedisConnection connection = connectionFactory.getConnection();
        JdkSerializationRedisSerializer serializationRedisSerializer = new JdkSerializationRedisSerializer();
        redisTemplate.setKeySerializer(serializationRedisSerializer);
        RedisSerializer keySerializer = redisTemplate.getKeySerializer();
        System.out.println(keySerializer.getClass().getName());
        String key = "zhou_try_lock";
        Boolean aBoolean = connection.setNX(keySerializer.serialize(key), key.getBytes());
        if (aBoolean) {
            Boolean expire = connection.expire(keySerializer.serialize(key), 30L);
//            connection.del("".getBytes(), "".getBytes());
            if (expire) {
                System.out.println("设置时间成功");
                if (redisTemplate.hasKey(key)) {
                    System.out.println("找到key值，将进行删除");
                    if (redisTemplate.delete(key)) {
                        System.out.println("删除key成功");
                    }
                } else {
                    System.out.println("未找到key");
                }
            }
        }
    }

}
