package com.maurodev.minhasfinancas.repositories;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.maurodev.minhasfinancas.entities.Usuario;



@SpringBootTest
@RunWith(SpringRunner.class)

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

}
