package com.smallking.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.collections.MappingChange;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;


/**
 * @program: learning-log
 * @description: Redis配置类
 * @author: smallking
 * @create: 2019-07-30 00:41
 **/
@Configurable
public class RedisConfig extends CachingConfigurerSupport {

    private final static Logger logger = Logger.getLogger(RedisConfig.class);
    /**
    * @Description: 自定义缓存key生成策略
    * @Author: smallking
    * @Date:  2019-07-30 00:41
    */
    @Bean
    @Override
    public KeyGenerator keyGenerator(){
        return (o, method, params) ->{
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()); // 类目
            sb.append(method.getName()); // 方法名
            for(Object param: params){
                sb.append(param.toString()); // 参数名
            }
            return sb.toString();
        };
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                // 60s缓存失效
                .entryTtl(Duration.ofSeconds(60))
                // 设置key的序列化方式
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
                // 设置value的序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
                // 不缓存null值
                .disableCachingNullValues();

        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();

        logger.info("自定义RedisCacheManager加载完成");
        return redisCacheManager;
    }
    // key键序列化方式
    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    // value值序列化方式
    private GenericJackson2JsonRedisSerializer valueSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        setSerializer(template);// 设置序列化工具
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    private void setSerializer(StringRedisTemplate template) {
//        @SuppressWarnings({ "rawtypes", "unchecked" })
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//    }
}
