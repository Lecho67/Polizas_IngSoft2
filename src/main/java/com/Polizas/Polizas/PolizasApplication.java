package com.Polizas.Polizas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolizasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolizasApplication.class, args);
//		RedisService redisService = new RedisService();
//		Transaccion transaccion = new Transaccion(1L,10.6,"USD");
//		redisService.saveTransaccion(3L,transaccion);
//		Transaccion transaccion1 = redisService.getTransaccion(3L);
//		System.out.println(transaccion1.toString());

	}

}
