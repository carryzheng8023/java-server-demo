/**
 * File Name：RedisCacheConfig.java
 *
 * Copyright Defonds Corporation 2015 
 * All Rights Reserved
 *
 */
package xin.carryzheng.ssmDemo.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import xin.carryzheng.ssmDemo.util.Const;

/**
 * 
 * Project Name：bdp 
 * Type Name：RedisCacheConfig 
 * Type Description：
 *  Author：Defonds
 * Create Date：2015-09-21
 * 
 * @version
 * 
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

		// Defaults
		redisConnectionFactory.setHostName(Const.REDIS_IP);
		redisConnectionFactory.setPort(Const.REDIS_PORT);
		redisConnectionFactory.setPassword(Const.REDIS_PASSWORD);
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {
		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

		// Number of seconds before expiration. Defaults to unlimited (0)
		cacheManager.setDefaultExpiration(Const.REDIS_DEFAULT_EXPIRE_TIME); // Sets the default expire time (in seconds)
		return cacheManager;
	}
	
	@Bean
	public KeyGenerator customKeyGenerator() {

		return (o, method, objects) ->{
				StringBuilder sb = new StringBuilder();
				sb.append(o.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();

		};
	}
}
