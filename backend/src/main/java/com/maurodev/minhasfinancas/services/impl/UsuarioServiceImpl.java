package com.maurodev.minhasfinancas.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurodev.minhasfinancas.entities.Usuario;
import com.maurodev.minhasfinancas.exception.ErroAutenticacao;
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
	
		Optional<Usuario> usuario = repository.findByEmail(email);
		
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuario nao encontrado para o email informado.");
		}
		
		if(!usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha invalida.");
		}
		
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		
		validarEmail(usuario.getEmail());
		
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {

       boolean exists = repository.existsByEmail(email);
       
       if (exists) {
    	   
    	   throw new RegraNegocioException("Ja existe usuario cadastrado com esse email.");
       }
		
	}
   
}
