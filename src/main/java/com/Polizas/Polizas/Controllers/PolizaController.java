package com.Polizas.Polizas.Controllers;

import com.Polizas.Polizas.Persistence.Entities.Poliza;
import com.Polizas.Polizas.Persistence.Repositories.PolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PolizaController {
    @Autowired
    private PolizaRepository polizaRepository;
    @PostMapping("/api/polizas")
    public ResponseEntity<Poliza> create(@RequestBody Poliza poliza){
        if(poliza.getId() !=null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(polizaRepository.save(poliza));

    }

    // 2.Recurso: Pólizas de Seguro

    @GetMapping("/api/polizas")

    public List<Poliza> findAll(){
        return polizaRepository.findAll();
    }

}
