package com.smallking.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

/**
 * @program: learning-log
 * @description: Jackson配置
 * @author: smallking
 * @create: 2019-07-30 01:43
 **/

//@Configurable
public class JacksonConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.sets
        return objectMapper;
    }
}
