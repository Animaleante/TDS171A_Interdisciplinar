/**
 * 
 */
package com.tds171a.soboru.models.comentario;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Comentario;

/**
 * @author Diogo
 *
 */
public class ComentarioModel extends ModelBase<Comentario> {
	
	/**
	 * Construtor iniciando o DAO
	 */
	public ComentarioModel() {
		dao = new ComentarioDAO();
	}

	/**
	 * M�todo que tr�s os coment�rios por receita.
	 * @param receitaId
	 * @return
	 */
	public List<Comentario> selecionarPorReceita(int receitaId) {
		return ((ComentarioDAO) dao).selecionarPorReceita(receitaId);
	}

	/**
	 * M�todo que remove um coment�rio de uma
	 * receita.
	 * @param receitaId
	 * @param usuarioId
	 * @return
	 */
	public boolean remover(int receitaId, int usuarioId) {
        return ((ComentarioDAO) dao).remover(receitaId, usuarioId);
    }
}
