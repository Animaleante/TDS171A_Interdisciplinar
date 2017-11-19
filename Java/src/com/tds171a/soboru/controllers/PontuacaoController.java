/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.pontuacao.PontuacaoModel;
import com.tds171a.soboru.vos.Pontuacao;

/**
 * Classe de controller da pontuacao
 * @author Diogo
 *
 */
public class PontuacaoController extends ControllerBase<Pontuacao> {
	
	/**
     * Construtor da classe de controller da pontuacao
     */
	public PontuacaoController() {
		model = new PontuacaoModel();
	}

	/**
	 * remove a pontuacao tirando o id da receita
	 * e o id do usuário.
	 */
	public boolean remover(int receitaId, int usuarioId) {
	    return ((PontuacaoModel)model).remover(receitaId, usuarioId);
	}
}
