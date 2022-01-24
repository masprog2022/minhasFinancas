package com.maurodev.minhasfinancas.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.maurodev.minhasfinancas.entities.Usuario;
import com.maurodev.minhasfinancas.exception.RegraNegocioException;
//import com.maurodev.minhasfinancas.exception.RegraNegocioException;
import com.maurodev.minhasfinancas.repositories.UsuarioRepository;
import com.maurodev.minhasfinancas.services.impl.UsuarioServiceImpl;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

	 @Autowired
	 UsuarioService service;
	 
	 @Autowired
	 UsuarioRepository repository;
	 
	// @Test(expected = Test.None.class)
	 
	 @BeforeEach
	 public void setUp() {
		 repository = Mockito.mock(UsuarioRepository.class);
		 service = new UsuarioServiceImpl(repository);
	 }
	 
	 
	 
    @Test
	public void deveValidarEmail() {
    	
    	
    	Assertions.assertDoesNotThrow(() -> {
    		
    	//UsuarioRepository usuarioRepositoryMock =  Mockito.mock(UsuarioRepository.class);
    		 
			// cenario
			//repository.deleteAll();
    		Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);
    		
    		
 
			// acao
			service.validarEmail("usuario@gmail.com");
		});
		
		 
	 }
    

    // @Test(expected = Test.RegraNegocioException.class)
     @Test
     public void deveExistirErroAoValidarEmailQuandoExistirEmailCadastrado() {
    	 
    	 Assertions.assertThrows(RegraNegocioException.class, () -> {
 			//cenario
    		 Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);
 			
 			//acao
 			service.validarEmail("usuario@gmail.com");
 		});
    	 
    	 
     }
}
