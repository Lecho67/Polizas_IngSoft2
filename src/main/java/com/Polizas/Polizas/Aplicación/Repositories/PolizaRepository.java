package com.Polizas.Polizas.Aplicación.Repositories;

import com.Polizas.Polizas.Dominio.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza,Long> {
}
