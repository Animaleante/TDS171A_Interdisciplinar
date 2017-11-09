/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.pontuacao.PontuacaoModel;
import com.tds171a.soboru.vos.Pontuacao;

/**
 * @author Diogo
 *
 */
public class PontuacaoController extends ControllerBase<Pontuacao> {
	
	/**
	 * 
	 */
	public PontuacaoController() {
		model = new PontuacaoModel();
	}
}
