/**
 * 
 */
package com.tds171a.soboru.models.usuario;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Usuario;

/**
 * @author Diogo
 *
 */
public class UsuarioModel extends ModelBase<Usuario> {

    /**
     * Construtor da classe UsuarioModel
     */
    public UsuarioModel() {
        dao = new UsuarioDAO();
    }

	public Usuario loginUsuario(String email, String senha) {
		return ((UsuarioDAO)dao).loginUsuario(email, senha);
	}

	public List<Usuario> selecionarUsuariosQueFavoritaram(int receitaId) {
		return ((UsuarioDAO) dao).selecionarUsuariosQueFavoritaram(receitaId);
	}

	public boolean reportou(int usuarioId, int receitaId) {
		return ((UsuarioDAO) dao).reportou(usuarioId, receitaId);
	}

	public boolean pontuou(int usuarioId, int receitaId) {
		return ((UsuarioDAO) dao).pontuou(usuarioId, receitaId);
	}
}
