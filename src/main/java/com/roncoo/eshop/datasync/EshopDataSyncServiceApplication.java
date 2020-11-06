package com.roncoo.eshop.datasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 数据同步服务
 * @author 41241
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EshopDataSyncServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopDataSyncServiceApplication.class, args); 
	}
	
	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(100);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000 * 10); 
		config.setTestOnBorrow(true);
		return new JedisPool(config, "192.168.101.105", 1111);
	}
	
}
