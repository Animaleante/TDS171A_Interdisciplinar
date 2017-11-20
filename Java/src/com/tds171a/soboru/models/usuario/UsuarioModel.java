/**
 * 
 */
package com.tds171a.soboru.models.usuario;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Usuario;

/**
 * Model de usu�rios
 * @author luiz.palte
 *
 */
public class UsuarioModel extends ModelBase<Usuario> {

    /**
     * Construtor da classe UsuarioModel
     * iniciando a DAO.
     */
    public UsuarioModel() {
        dao = new UsuarioDAO();
    }

    /**
     * M�todo tr�s um boolean mostrando se o cliente
     * est� logado.
     * @param email
     * @param senha
     * @return
     */
	public Usuario loginUsuario(String email, String senha) {
		return ((UsuarioDAO)dao).loginUsuario(email, senha);
	}

	/**
	 * Tr�s uma lista de usu�rios que favoritaram 
	 * determinada receita.
	 * @param receitaId
	 * @return
	 */
	public List<Usuario> selecionarUsuariosQueFavoritaram(int receitaId) {
		return ((UsuarioDAO) dao).selecionarUsuariosQueFavoritaram(receitaId);
	}

	/**
	 * Tr�s a informa��o se o usu�rio
	 * reportou determinada receita.
	 * @param usuarioId
	 * @param receitaId
	 * @return
	 */
	public boolean reportou(int usuarioId, int receitaId) {
		return ((UsuarioDAO) dao).reportou(usuarioId, receitaId);
	}

	/**
	 * Verifica que o usu�rio pontuou
	 * determinada receita.
	 * @param usuarioId
	 * @param receitaId
	 * @return
	 */
	public boolean pontuou(int usuarioId, int receitaId) {
		return ((UsuarioDAO) dao).pontuou(usuarioId, receitaId);
	}
}
