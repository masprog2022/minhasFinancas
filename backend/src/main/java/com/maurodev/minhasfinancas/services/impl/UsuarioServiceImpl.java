package com.maurodev.minhasfinancas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurodev.minhasfinancas.entities.Usuario;
import com.maurodev.minhasfinancas.exception.RegraNegocioException;
import com.maurodev.minhasfinancas.repositories.UsuarioRepository;
import com.maurodev.minhasfinancas.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	private UsuarioRepository repository;
	
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {

		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validarEmail(String email) {

       boolean exists = repository.existsByEmail(email);
       
       if (exists) {
    	   
    	   throw new RegraNegocioException("Ja existe usuario cadastrado com esse email.");
       }
		
	}
   
}
