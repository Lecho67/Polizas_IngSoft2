package com.Polizas.Polizas.Persistence.Repositories;

import com.Polizas.Polizas.Persistence.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
