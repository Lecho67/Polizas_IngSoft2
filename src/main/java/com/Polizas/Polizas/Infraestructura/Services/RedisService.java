package com.Polizas.Polizas.Infraestructura.Services;

import com.Polizas.Polizas.Dominio.Models.Transaccion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class RedisService {
    String host = "redis-16928.c114.us-east-1-4.ec2.redns.redis-cloud.com";
    int port = 16928;
    String password = "EeiX8YlyA7LAx6h3RxD7ZCKVPShktB3k";
    int database = 0;
    private final Jedis jedis;
    private ObjectMapper objectMapper;
    public RedisService() {
        jedis = new Jedis(host, port);
        jedis.auth(password);
        jedis.select(database);

    }
    public boolean exists(Long id){
        return jedis.exists(String.valueOf(id));
    }

//    public void save(Long id, double valor) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String fechaHoraActualStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//        // Guardar la fecha y hora actual junto con el valor en Redis
//        jedis.rpush(String.valueOf(id), fechaHoraActualStr, String.valueOf(valor));
//
//        // Establecer expiración en 20 minutos para la clave
//        jedis.expire(String.valueOf(id), 20 * 60);
//    }
//    public List<String> getData(Long id) {
//        return jedis.lrange(String.valueOf(id), 0, -1);
//    }

    // guardar la transaccion en redis hasta que se confirme el pago
    public void saveTransaccion(Long id, Transaccion transaccion) {
        // objeto para pasar de un objeto a un Json
        objectMapper = new ObjectMapper();
        // obtiene la fecha y hora del momento actual
        LocalDateTime localDateTime = LocalDateTime.now();
        //pasa la fecha a un string
        String stringDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transaccion.setHoraTrm(stringDate);
        String transaccionJson;
        try {
            transaccionJson = objectMapper.writeValueAsString(transaccion);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        jedis.set(String.valueOf(id), transaccionJson);
        jedis.expire(String.valueOf(id),20*60);
    }

    // obtener el transaccion
    public Transaccion getTransaccion(Long id){
        String trasaccionJson = jedis.get(String.valueOf(id));
        try {
            return objectMapper.readValue(trasaccionJson, Transaccion.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}