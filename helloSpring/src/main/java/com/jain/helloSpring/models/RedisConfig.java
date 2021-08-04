package com.jain.helloSpring.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RedisConfig {
	 @Bean
	    JedisConnectionFactory jedisConnectionFactory() {
	        return new JedisConnectionFactory();
	    }
	      
	    // Setting up the Redis template object.
	    @Bean
	    public RedisTemplate<String, Object> redisTemplate() {
	        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
	        redisTemplate.setConnectionFactory(jedisConnectionFactory());
	        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	        return redisTemplate;
	    }
	}
