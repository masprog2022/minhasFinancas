package com.maurodev.minhasfinancas.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.maurodev.minhasfinancas.entities.Usuario;

 


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	EntityManager entityManager;
	
	
   @Test
	public void deveVerificarAExistenciaDeUmEmail() {
		
		// cenario

		Usuario usuario = criarUsuario();
		//repository.save(usuario);
		
		entityManager.persist(usuario);

		//acao / executar

		boolean resultado = repository.existsByEmail("usuario@gmail.com");

		// verificacao

		Assertions.assertThat(resultado).isTrue();

		
	}
    
    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComEmail() {
    	
    	// cenario
    	
    	//repository.deleteAll();
    	
    	// acao
    	
    	boolean resultado = repository.existsByEmail("usuario@gmail.com");
    	
    	// verificaco
    	
    	Assertions.assertThat(resultado).isFalse();
    	
    	
    }
    
    @Test
    public void devePersistirUmUsuarioNaBaseDeDados() {
    	// cenario
    	Usuario usuario = criarUsuario();
    	// acao
    	
    	Usuario usuarioSalvo = repository.save(usuario);
    	
    	// verificacao
    	Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
    }
    
    @Test
    public void deveBuscarUmUsuarioPorEmail() {
    	
        // cenario
    	Usuario usuario = criarUsuario();
    	
    	entityManager.persist(usuario);
    	
    	//verificacao

    	Optional<Usuario> resultado = repository.findByEmail("usuario@gmail.com");
    	
    	Assertions.assertThat(resultado.isPresent()).isTrue();
    	
    }
    
    @Test
    public void deveRetornarVazioAoBuscarUmUsuarioPorEmailQuandoNaoExisteNaBase() {
    	

    	//verificacao

    	Optional<Usuario> resultado = repository.findByEmail("usuario@gmail.com");
    	
    	Assertions.assertThat(resultado.isPresent()).isFalse();
    	
    }
    
    public static Usuario criarUsuario() {
    	
         return  Usuario.builder()
    			.nome("usuario")
    			.email("usuario@gmail.com")
    			.senha("1234")
    			.build();
    	
    }
    

}
