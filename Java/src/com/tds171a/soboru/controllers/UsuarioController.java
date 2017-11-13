package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.usuario.UsuarioModel;
import com.tds171a.soboru.vos.Usuario;

/**
 * Classe de controller do Usuario
 * @author Diogo
 *
 */
public class UsuarioController extends ControllerBase<Usuario> {
	
	/**
	 *Construtor do usu�ro 
	 */
	public UsuarioController() {
		model = new UsuarioModel();
	}

	/**
	 * m�todo que retorna um objeto do tipo usuario
	 * com o usuario logado.
	 */
	public Usuario loginUsuario(String email, String senha) {
		return ((UsuarioModel)model).loginUsuario(email, senha);
	}
}
