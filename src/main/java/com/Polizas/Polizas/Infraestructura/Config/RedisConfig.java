package com.Polizas.Polizas.Infraestructura.Config;

import io.lettuce.core.dynamic.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
    @Bean
    public Jedis jedis() {
        String host = "redis-16928.c114.us-east-1-4.ec2.redns.redis-cloud.com";
        int port = 16928;
        String password = "EeiX8YlyA7LAx6h3RxD7ZCKVPShktB3k";
        int database = 0;

        Jedis jedis = new Jedis(host, port);
        jedis.auth(password);
        jedis.select(database);
        return jedis;
}


}
