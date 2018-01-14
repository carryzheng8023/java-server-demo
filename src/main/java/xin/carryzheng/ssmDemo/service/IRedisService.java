package xin.carryzheng.ssmDemo.service;

/**
 * Created by zhengxin on 18/1/13.
 */
public interface IRedisService {

    String cacheable(int key) throws Exception;
    String cachePut(int key) throws Exception;
    String cacheEvict(int key) throws Exception;

    void producer(String key, String value);


}
