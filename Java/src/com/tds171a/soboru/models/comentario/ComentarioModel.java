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
	 * 
	 */
	public ComentarioModel() {
		dao = new ComentarioDAO();
	}

	public List<Comentario> selecionarPorReceita(int receitaId) {
		return ((ComentarioDAO) dao).selecionarPorReceita(receitaId);
	}

	public boolean remover(int receitaId, int usuarioId) {
        return ((ComentarioDAO) dao).remover(receitaId, usuarioId);
    }
}
