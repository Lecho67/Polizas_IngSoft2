package com.Polizas.Polizas.Dominio.Repositories;

import com.Polizas.Polizas.Dominio.Models.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza,Long> {
}
