package com.mrxianx.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Funnel;
import com.mrxianx.config.redis.BloomFilterHelper;
import com.mrxianx.utils.redis.RedisBloomTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xianxiong
 * @Date 2020/4/22
 */
@RestController
public class TestController {

    @Resource
    RedisBloomTool redisBloomTool;

    /**
     * 定义bloom过滤器的参数
     */
    private BloomFilterHelper<String> orderBloomFilterHelper = new BloomFilterHelper<>((Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8)
            .putString(from, Charsets.UTF_8), 100 , 0.01);


    @GetMapping(value = "/addBloom")
    public String bloomTest(@RequestParam("key")String key){
        redisBloomTool.addByBloomFilter(orderBloomFilterHelper,"userId",key);
        return "success";
    }

    @GetMapping(value = "/exitKey")
    public String exitKey(@RequestParam("key") String key){

        boolean userId = redisBloomTool.includeByBloomFilter(orderBloomFilterHelper, "userId", key);
        if (userId == true){
            return "存在";
        }
        return "bucunzai ";
    }
}
