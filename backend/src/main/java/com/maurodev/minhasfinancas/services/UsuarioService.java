package com.maurodev.minhasfinancas.services;

import com.maurodev.minhasfinancas.entities.Usuario;

public interface UsuarioService {
	
	Usuario autenticar(String email, String senha);
	
    Usuario salvarUsuario(Usuario usuario);
    
    void validarEmail(String email);
}
