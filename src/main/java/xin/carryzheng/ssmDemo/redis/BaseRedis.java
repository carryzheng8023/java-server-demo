package xin.carryzheng.ssmDemo.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import xin.carryzheng.ssmDemo.util.Const;

import javax.annotation.Resource;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhengxin on 18/1/13.
 */
public class BaseRedis<E> implements Serializable{

    @Resource
    private RedisTemplate<Serializable,Object> redisTemplate;

    /**
     * 写入缓存
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param key
     * @param value
     * @param expireTime
     */
    protected boolean setCache(String key, Object value, Long expireTime) {
        boolean result = false;
        try{
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 读取缓存
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param key
     * @return
     */
    protected Object getCache(String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }



    /**
     * 判断缓存中是否有对应的value
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param key
     * @return
     */
    protected boolean exists(String key) {

        return redisTemplate.hasKey(key);
    }

    /**
     *清除缓存
     * */
    protected void deleteCache(String key){
        redisTemplate.delete(key);
    }

    /**
     *清除缓存
     * */
    protected void deleteCache(ArrayList<String> keys){
        redisTemplate.delete(keys);
    }


    /**
     * 创建缓存key
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param targetName
     * @param methodName
     * @param arguments
     * @return
     */
    protected String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sbu = new StringBuffer();
        sbu.append(targetName).append("_").append(methodName);
        if((arguments!=null)&&(arguments.length!=0)){
            for(int i=0;i<arguments.length;i++){
                sbu.append("_").append(arguments[i]);
            }
        }
        return sbu.toString();
    }


}
