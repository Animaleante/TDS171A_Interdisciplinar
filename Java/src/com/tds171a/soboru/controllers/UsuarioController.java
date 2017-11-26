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

	/**
	 * Trás lista de usuários que favoritaram 
	 * determinada receita.
	 * @param receitaId
	 * @return
	 */
	public List<Usuario> selecionarUsuariosQueFavoritaram(int receitaId) {
		return ((UsuarioModel) model).selecionarUsuariosQueFavoritaram(receitaId);
	}

	/**
	 * Verifica se o cliente reportou
	 * a receita.
	 * @param usuarioId
	 * @param receitaId
	 * @return
	 */
	public boolean reportou(int usuarioId, int receitaId) {
		return ((UsuarioModel) model).reportou(usuarioId, receitaId);
	}

	/**
	 * Verifica se o cliente pontuou a receita.
	 * @param usuarioId
	 * @param receitaId
	 * @return
	 */
	public boolean pontuou(int usuarioId, int receitaId) {
		return ((UsuarioModel) model).pontuou(usuarioId, receitaId);
	}
}
