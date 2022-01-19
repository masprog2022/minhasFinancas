package com.maurodev.minhasfinancas.repositories;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.maurodev.minhasfinancas.entities.Usuario;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
   @Test
	public void deveVerificarAExistenciaDeUmEmail() {
		
		// cenario

		Usuario usuario = Usuario.builder().nome("usuario").email("usuario@gmail.com").build();
		repository.save(usuario);

		//acao / executar

		boolean resultado = repository.existsByEmail("usuario@gmail.com");

		// verificacao

		Assertions.assertThat(resultado).isTrue();

		
	}
    
    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
    	
    	// cenario
    	
    	repository.deleteAll();
    	
    	// acao
    	
    	boolean resultado = repository.existsByEmail("usuario@gmail.com");
    	
    	// verificaco
    	
    	Assertions.assertThat(resultado).isFalse();
    	
    	
    }
    

}
