package com.cskaoyan.service.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


/**
 * @version 1.0
 * @ClassName GuavaCacheSerivce
 * @Description 使用GuavaCache实现本地缓存
 * @Author wangdi
 * @Date 2019/10/26 22:20
 **/
@Component
public class GuavaCacheSerivce {

    private Cache<String,Object> cache = null;

    @PostConstruct
    public void init(){
        cache = CacheBuilder.newBuilder()
                .initialCapacity(10) // 设置初始容量
                .maximumSize(100) // 设置最大容量，当容量满了之后就按照LRU策略淘汰
                .expireAfterWrite(30, TimeUnit.SECONDS) //设置多少秒之后失效
                .build();
        System.out.println("缓存初始化成功");
    }

    public void set(String key,Object object) {
        cache.put(key,object);
    }
    public  Object get(String key) {
        return cache.getIfPresent(key);
    }
}
