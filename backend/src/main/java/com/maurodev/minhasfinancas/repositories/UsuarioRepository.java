package com.maurodev.minhasfinancas.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maurodev.minhasfinancas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Optional<Usuario> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);



}
