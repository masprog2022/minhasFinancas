package com.maurodev.minhasfinancas.exception;

import java.io.Serializable;

public class ErroAutenticacao extends RuntimeException implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErroAutenticacao(String message) {
		super(message);
	}

}
