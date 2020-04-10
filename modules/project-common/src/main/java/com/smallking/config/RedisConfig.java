package com.smallking.config;

import org.jboss.logging.Logger;
import org.springframework.cache.annotation.CachingConfigurerSupport;

import java.time.Duration;


/**
 * @program: learning-log
 * @description: Redis配置类
 * @author: smallking
 * @create: 2019-07-30 00:41
 **/
//@Configuration
public class RedisConfig extends CachingConfigurerSupport {

//    private final static Logger logger = Logger.getLogger(RedisConfig.class);
//    /**
//    * @Description: 自定义缓存key生成策略
//    * @Author: smallking
//    * @Date:  2019-07-30 00:41
//    */
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator(){
//        return (o, method, params) ->{
//            StringBuilder sb = new StringBuilder();
//            sb.append(o.getClass().getName()); // 类目
//            sb.append(method.getName()); // 方法名
//            for(Object param: params){
//                sb.append(param.toString()); // 参数名
//            }
//            return sb.toString();
//        };
//    }
//
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                // 60s缓存失效
//                .entryTtl(Duration.ofSeconds(60))
//                // 设置key的序列化方式
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
//                // 设置value的序列化方式
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
//                // 不缓存null值
//                .disableCachingNullValues();
//
//        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
//                .cacheDefaults(config)
//                .transactionAware()
//                .build();
//
//        logger.info("自定义RedisCacheManager加载完成");
//        return redisCacheManager;
//    }
//    // key键序列化方式
//    private RedisSerializer<String> keySerializer() {
//        return new StringRedisSerializer();
//    }
//
//    // value值序列化方式
//    private GenericJackson2JsonRedisSerializer valueSerializer(){
//        return new GenericJackson2JsonRedisSerializer();
//    }
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate templates = new StringRedisTemplate(factory);
//        setSerializer(templates);// 设置序列化工具
//        templates.afterPropertiesSet();
//        return templates;
//    }
//
//    private void setSerializer(StringRedisTemplate templates) {
//        @SuppressWarnings({ "rawtypes", "unchecked" })
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        templates.setValueSerializer(jackson2JsonRedisSerializer);
//    }
}
