package br.com._0.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com._0.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    
    Optional<Usuario>findByEmail(String email);
    @Transactional 
    void deleteByEmail(String email);
    


}
