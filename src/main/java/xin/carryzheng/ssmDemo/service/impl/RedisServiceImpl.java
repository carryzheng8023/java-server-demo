package xin.carryzheng.ssmDemo.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import xin.carryzheng.ssmDemo.base.BaseService;
import xin.carryzheng.ssmDemo.service.IRedisService;

/**
 * Created by zhengxin on 18/1/13.
 */
@Service
public class RedisServiceImpl extends BaseService implements IRedisService {

    /**
     * 用于查询的注解，第一次查询的时候返回该方法返回值，并向redis服务器保存数据，
     * 以后的查询将不再执行方法体内的代码，而是直接查询redis服务器获取数据并返回。
     * value属性做键，key属性则可以看作为value的子键，
     * 一个value可以有多个key组成不同值存在redis服务器，
     * 这里再介绍一个属性是condition，用法condition="#key<10"，
     * 就是说当key小于10的时候才将数据保存到redis服务器
     */
    @Override
    @Cacheable(value="redis",key="#key")
    public String cacheable(int key) throws Exception {
        return "cacheable";
    }

    /**
     * 用于更新数据库或新增数据时的注解，更新redis服务器中该value的值
     */
    @Override
    @CachePut(value="redis",key="#key")
    public String cachePut(int key) throws Exception {
        return "cachePut";
    }

    /**
     * 用于删除数据操作时的注解，删除redis数据库中该value对应的数据
     */
    @Override
    @CacheEvict(value="redis", key="#key")
    public String cacheEvict(int key) throws Exception {
        return "cacheEvict";
    }


    @Override
    public void producer(String key, String value) {
        return;
    }
}
