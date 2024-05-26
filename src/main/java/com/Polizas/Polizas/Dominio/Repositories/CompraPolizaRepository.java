package com.Polizas.Polizas.Dominio.Repositories;

import com.Polizas.Polizas.Dominio.Models.CompraPoliza;
import com.Polizas.Polizas.Dominio.Models.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraPolizaRepository extends JpaRepository<CompraPoliza, Long> {

    @Query("Select cp.poliza From CompraPoliza cp where cp.usuario.id = :userId")
    List<Poliza> findPolizaByUserId(Long userId);
}
