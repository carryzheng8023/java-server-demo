package xin.carryzheng.ssmDemo.redis;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * Created by zhengxin on 18/1/13.
 */
public class MethodCacheInterceptor //implements MethodInterceptor
{

//    @Resource
//    private RedisTemplate<Serializable,Object> redisTemplate;
//
//    private Long defaultCacheExpireTime = 600l;//缓存默认的过期时间，这里设置为10秒
//
//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        Object value = null;
//        String targetName = invocation.getThis().getClass().getName();
//        String methodName = invocation.getMethod().getName();
//
//        Object[] arguments = invocation.getArguments();
//        String key = getCacheKey(targetName,methodName,arguments);
//        try{
//            //判断是否有缓存
//            if(exists(key)){
//                return getCache(key);
//            }
//            //写入缓存
//            value = invocation.proceed();
//            if(value!=null){
//                final String tkey = key;
//                final Object tvalue = value;
//                new Thread(new Runnable(){
//                    @Override
//                    public void run() {
//                        setCache(tkey,tvalue,defaultCacheExpireTime);
//                    }
//                }).start();
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//            if(value==null){
//                return invocation.proceed();
//            }
//        }
//        return value;
//    }
//
//    /**
//     * 写入缓存
//     * <请替换成功能描述> <br>
//     * <请替换成详细描述>
//     * @param key
//     * @param value
//     * @param expireTime
//     */
//    protected boolean setCache(String key, Object value, Long expireTime) {
//        boolean result = false;
//        try{
//            ValueOperations<Serializable, Object> operations = redisTemplate
//                    .opsForValue();
//            operations.set(key, value);
//            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//            result = true;
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * 读取缓存
//     * <请替换成功能描述> <br>
//     * <请替换成详细描述>
//     * @param key
//     * @return
//     */
//    protected Object getCache(String key) {
//        Object result = null;
//        ValueOperations<Serializable, Object> operations = redisTemplate
//                .opsForValue();
//        result = operations.get(key);
//        return result;
//    }
//
//
//
//    /**
//     * 判断缓存中是否有对应的value
//     * <请替换成功能描述> <br>
//     * <请替换成详细描述>
//     * @param key
//     * @return
//     */
//    protected boolean exists(String key) {
//
//        return redisTemplate.hasKey(key);
//    }
//
//    /**
//     * 创建缓存key
//     * <请替换成功能描述> <br>
//     * <请替换成详细描述>
//     * @param targetName
//     * @param methodName
//     * @param arguments
//     * @return
//     */
//    protected String getCacheKey(String targetName, String methodName, Object[] arguments) {
//        StringBuffer sbu = new StringBuffer();
//        sbu.append(targetName).append("_").append(methodName);
//        if((arguments!=null)&&(arguments.length!=0)){
//            for(int i=0;i<arguments.length;i++){
//                sbu.append("_").append(arguments[i]);
//            }
//        }
//        return sbu.toString();
//    }
}
