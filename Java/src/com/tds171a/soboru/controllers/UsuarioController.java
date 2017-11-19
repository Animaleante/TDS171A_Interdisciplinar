package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.usuario.UsuarioModel;
import com.tds171a.soboru.vos.Usuario;

/**
 * Classe de controller do Usuario
 * @author Diogo
 *
 */
public class UsuarioController extends ControllerBase<Usuario> {
	
	/**
	 *Construtor do usuáro 
	 */
	public UsuarioController() {
		model = new UsuarioModel();
	}

	/**
	 * método que retorna um objeto do tipo usuario
	 * com o usuario logado.
	 */
	public Usuario loginUsuario(String email, String senha) {
		return ((UsuarioModel)model).loginUsuario(email, senha);
	}

	public List<Usuario> selecionarUsuariosQueFavoritaram(int receitaId) {
		return ((UsuarioModel) model).selecionarUsuariosQueFavoritaram(receitaId);
	}

	public boolean reportou(int usuarioId, int receitaId) {
		return ((UsuarioModel) model).reportou(usuarioId, receitaId);
	}

	public boolean pontuou(int usuarioId, int receitaId) {
		return ((UsuarioModel) model).pontuou(usuarioId, receitaId);
	}
}
