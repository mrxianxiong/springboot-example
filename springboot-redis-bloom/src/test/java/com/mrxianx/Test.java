package com.mrxianx;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author xianxiong
 * @Date 2020/4/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @org.junit.Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }
}
