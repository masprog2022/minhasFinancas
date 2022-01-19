package com.maurodev.minhasfinancas.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.maurodev.minhasfinancas.entities.Usuario;



@SpringBootTest
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
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
