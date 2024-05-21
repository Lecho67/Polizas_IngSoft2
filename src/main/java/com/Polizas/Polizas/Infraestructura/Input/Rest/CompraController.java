package com.Polizas.Polizas.Infraestructura.Input.Rest;

import com.Polizas.Polizas.Dominio.CompraPoliza;
import com.Polizas.Polizas.Dominio.Poliza;
import com.Polizas.Polizas.Dominio.Transaccion;
import com.Polizas.Polizas.Dominio.Usuario;
import com.Polizas.Polizas.Aplicación.Repositories.CompraPolizaRepository;
import com.Polizas.Polizas.Aplicación.Repositories.PolizaRepository;
import com.Polizas.Polizas.Aplicación.Repositories.TransaccionRepository;
import com.Polizas.Polizas.Aplicación.Repositories.UsuarioRepository;
import com.Polizas.Polizas.Aplicación.Services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompraController {

    @Autowired
    private CompraPolizaRepository compraPolizaRepository;

    @Autowired
    private PolizaRepository polizaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private RedisService redisService;

    // 3.Recurso: Compra de Póliza
    @PostMapping("/api/compra-polizas")
    public ResponseEntity<CompraPoliza> createCompraPoliza(
            @RequestBody CompraPoliza request
    ) {
        // Obtener la poliza y el usuario del cuerpo de la petición
        Long polizaId = request.getPoliza().getId();
        Long usuarioId = request.getUsuario().getId();
        boolean existsRedis = redisService.exists(usuarioId);

        if(!existsRedis) return ResponseEntity.badRequest().build();
            // Verificar si existe un registro en Redis para el usuario
            Transaccion transaccionRedis = redisService.getTransaccion(usuarioId);

            if (transaccionRedis != null) {
                // Si existe una transacción en Redis, guardarla en la base de datos
                Transaccion savedTransaccion = transaccionRepository.save(transaccionRedis);

                // Crear la compra con la transacción guardada
                Optional<Poliza> optionalPoliza = polizaRepository.findById(polizaId);
                Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);

                if (optionalPoliza.isPresent() && optionalUsuario.isPresent()) {
                    Poliza poliza = optionalPoliza.get();
                    Usuario usuario = optionalUsuario.get();

                    CompraPoliza compraPoliza = new CompraPoliza();
                    compraPoliza.setFormaDePago(request.getFormaDePago());
                    compraPoliza.setPoliza(poliza);
                    compraPoliza.setUsuario(usuario);
                    compraPoliza.setTransaccion(savedTransaccion);

                    CompraPoliza savedCompraPoliza = compraPolizaRepository.save(compraPoliza);
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedCompraPoliza);
                } else {
                    return ResponseEntity.notFound().build();
                }
            } else {
                // Si no hay una transacción en Redis, retornar un error
                return ResponseEntity.badRequest().build();

            }
        }


        // 4.Recurso: Detalles de Póliza por Usuario
        @GetMapping("/api/poliza/{id}")

        public List<Poliza> findPolizaByUserId(@PathVariable("id") Long id){
            return compraPolizaRepository.findPolizaByUserId(id);
        }

}
