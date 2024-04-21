package com.Polizas.Polizas.Controllers;


import com.Polizas.Polizas.Persistence.Entities.Usuario;
import com.Polizas.Polizas.Persistence.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){

        if( usuario.getId() != null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    // 1.Recurso: Usuarios

    @GetMapping("/api/usuarios")

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }


}

//    @GetMapping("/api/usuario/polizas/{id}")
//
//    public ResponseEntity<List<CompraPoliza>> findAll(@PathVariable("id") Long id){
//
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        if(usuario.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(usuario.get().getCompraPolizas());
//    }


