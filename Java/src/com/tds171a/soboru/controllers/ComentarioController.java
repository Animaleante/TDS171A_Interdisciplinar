/**
 * 
 */
package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.comentario.ComentarioModel;
import com.tds171a.soboru.vos.Comentario;

/**
 * Classe de controller do Comentario
 * @author Diogo
 *
 */
public class ComentarioController extends ControllerBase<Comentario> {

	/**
     * Construtor da classe de controller do Comentario
     */
	public ComentarioController() {
		model = new ComentarioModel();
	}

	/**
	 * returna uma lista de receita
	 */
	public List<Comentario> selecionarPorReceita(int receitaId) {
		return ((ComentarioModel) model).selecionarPorReceita(receitaId);
	}

	/**
	 * remove a pontuacao tirando o id da receita
	 * e o id do usuário.
	 */
	public boolean remover(int receitaId, int usuarioId) {
	    return ((ComentarioModel)model).remover(receitaId, usuarioId);
	}
}
