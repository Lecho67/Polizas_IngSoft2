package com.Polizas.Polizas.Dominio.Repositories;

import com.Polizas.Polizas.Dominio.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
