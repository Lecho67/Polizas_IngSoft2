package com.Polizas.Polizas.Persistence.Repositories;

import com.Polizas.Polizas.Persistence.Entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
}
