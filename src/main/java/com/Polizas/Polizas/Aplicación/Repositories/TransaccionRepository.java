package com.Polizas.Polizas.Aplicación.Repositories;

import com.Polizas.Polizas.Dominio.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
}
