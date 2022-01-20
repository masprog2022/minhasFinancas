package com.maurodev.minhasfinancas.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.maurodev.minhasfinancas.entities.Usuario;
import com.maurodev.minhasfinancas.exception.RegraNegocioException;
//import com.maurodev.minhasfinancas.exception.RegraNegocioException;
import com.maurodev.minhasfinancas.repositories.UsuarioRepository;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

	 @Autowired
	 UsuarioService service;
	 
	 @Autowired
	 UsuarioRepository repository;
	 
	// @Test(expected = Test.None.class)
	 
	 
	 
    @Test
	public void deveValidarEmail() {
    	
    	
    	Assertions.assertDoesNotThrow(() -> {
    		
    	UsuarioRepository usuarioRepositoryMock =  Mockito.mock(UsuarioRepository.class);
    		 
			// cenario
			repository.deleteAll();
 
			// acao
			service.validarEmail("usuario@gmail.com");
		});
		
		 
	 }
    

    // @Test(expected = Test.RegraNegocioException.class)
     @Test
     public void deveExistirErroAoValidarEmailQuandoExistirEmailCadastrado() {
    	 
    	 Assertions.assertThrows(RegraNegocioException.class, () -> {
 			//cenario
 			Usuario usuario = Usuario.builder().nome("usuario").email("usuario@gmail.com").build();		
 			repository.save(usuario);
  
 			//acao
 			service.validarEmail("usuario@gmail.com");
 		});
    	 
    	 
     }
}
