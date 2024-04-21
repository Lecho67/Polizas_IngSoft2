package com.Polizas.Polizas.Persistence.Repositories;

import com.Polizas.Polizas.Persistence.Entities.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza,Long> {
}
