package com.Polizas.Polizas;

import com.Polizas.Polizas.Persistence.Entities.Transaccion;
import com.Polizas.Polizas.Services.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class PolizasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolizasApplication.class, args);
		RedisService redisService = new RedisService();
		Transaccion transaccion = new Transaccion(1L,10.6,"USD");
		redisService.saveTransaccion(3L,transaccion);
		Transaccion transaccion1 = redisService.getTransaccion(3L);
		System.out.println(transaccion1.toString());

	}

}
